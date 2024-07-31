package com.fermers_marketplace.fermers.presentation.activity

import android.os.Build
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.LinearLayout
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.fermers_marketplace.fermers.R
import com.fermers_marketplace.fermers.data.model.ButtonConfig
import com.fermers_marketplace.fermers.databinding.ActivityMainBinding
import com.fermers_marketplace.fermers.presentation.activity.viewmodel.MainViewModel
import com.google.android.material.shape.MaterialShapeDrawable
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    private lateinit var navController: NavController

    private val buttonConfigs = listOf(
        ButtonConfig(R.id.home_button_layout, R.id.home_ib, R.id.home_tv, R.drawable.home, R.drawable.home_selector_vectors, R.id.homeFragment),
        ButtonConfig(R.id.catalog_button_layout, R.id.catalog_ib, R.id.catalog_tv, R.drawable.ic_catalog, R.drawable.ic_catalog_vector, R.id.catalogFragment),
        ButtonConfig(R.id.chosen_button_layout, R.id.chosen_ib, R.id.chosen_tv, R.drawable.chosen, R.drawable.chosen_selector_vectors, R.id.chosenFragment),
        ButtonConfig(R.id.profile_button_layout, R.id.profile_ib, R.id.profile_tv, R.drawable.profile, R.drawable.profile_selector_vectors, R.id.profileFragment)
    )

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupBottomAppBarCornerRadius()

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
        navController = navHostFragment.navController

        val fragmentsWithoutBottomNav = setOf(
            R.id.splashFragment,
            R.id.viewPagerFragment
        )

        navController.addOnDestinationChangedListener { _, destination, _ ->
            with(binding) {
                if (!fragmentsWithoutBottomNav.contains(destination.id)) {
                    bottomAppBar.isVisible = true
                    fab.isVisible = true
                    supportActionBar?.hide()
                } else {
                    bottomAppBar.isVisible = false
                    fab.isVisible = false
                    supportActionBar?.show()
                }
            }
        }

        buttonConfigs.forEach { config ->
            val layout = findViewById<LinearLayout>(config.layoutId)
            layout.setOnClickListener { view ->
                view.startAnimation(AnimationUtils.loadAnimation(this, R.anim.alpha))
                viewModel.setupButtonClickListener(this, layout, config, navController)
            }
        }

        val initialLayout = findViewById<LinearLayout>(buttonConfigs[0].layoutId)
        viewModel.selectInitialButton(this, initialLayout, buttonConfigs[0])
    }

    private fun setupBottomAppBarCornerRadius() {
        val radius = resources.getDimension(R.dimen.corner_radius)
        val bottomBarBackground = binding.bottomAppBar.background as MaterialShapeDrawable
        bottomBarBackground.shapeAppearanceModel =
            bottomBarBackground.shapeAppearanceModel.toBuilder()
                .setAllCornerSizes(radius)
                .build()
    }

    override fun onDestroy() {
        super.onDestroy()
        navController.removeOnDestinationChangedListener { _, _, _ -> }
    }

}