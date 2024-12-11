package com.fermers_marketplace.fermers.presentation.activity

import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.LinearLayout
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.fermers_marketplace.fermers.common.ScrollToTopListener
import com.fermers_marketplace.fermers.R
import com.fermers_marketplace.fermers.data.model.ButtonConfig
import com.fermers_marketplace.fermers.databinding.ActivityMainBinding
import com.fermers_marketplace.fermers.presentation.activity.viewmodel.MainViewModel
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior
import com.google.android.material.bottomappbar.BottomAppBar
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupBottomAppBar()
        initNavController()
        setupFabScrollUp()
        setupButtonConfigs()
    }

    private fun initNavController() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
        navController = navHostFragment.navController

        val fragmentsWithBottomNav = setOf(R.id.homeFragment, R.id.catalogFragment, R.id.chosenFragment, R.id.profileFragment)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            with(binding) {
                val isBottomNavVisible = fragmentsWithBottomNav.contains(destination.id)
                bottomAppBar.isVisible = isBottomNavVisible
                fab.isVisible = isBottomNavVisible
                upBtn.isVisible = isBottomNavVisible
                supportActionBar?.let { if (isBottomNavVisible) it.hide() else it.show() }
            }
        }
    }

    private fun setupFabScrollUp() {
        binding.upBtn.setOnClickListener {
            val currentFragment = (supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment).childFragmentManager.fragments.firstOrNull()
            (currentFragment as? ScrollToTopListener)?.scrollToTop()
        }
    }

    private fun setupButtonConfigs() {
        buttonConfigs.forEach { config ->
            findViewById<LinearLayout>(config.layoutId).apply {
                setOnClickListener {
                    startAnimation(AnimationUtils.loadAnimation(this@MainActivity, R.anim.alpha))
                    viewModel.setupButtonClickListener(this@MainActivity, this, config, navController)
                }
            }
        }
        val initialLayout = findViewById<LinearLayout>(buttonConfigs[0].layoutId)
        viewModel.selectInitialButton(this, initialLayout, buttonConfigs[0])
    }

    private fun setupBottomAppBar() {
        val radius = resources.getDimension(R.dimen.corner_radius)
        val bottomBarBackground = binding.bottomAppBar.background as MaterialShapeDrawable
        bottomBarBackground.shapeAppearanceModel = bottomBarBackground.shapeAppearanceModel.toBuilder()
            .setAllCornerSizes(radius)
            .build()

        val bottomNavigationParams = binding.bottomAppBar.layoutParams as CoordinatorLayout.LayoutParams
        bottomNavigationParams.behavior = HideBottomViewOnScrollBehavior<BottomAppBar>()
        binding.bottomAppBar.layoutParams = bottomNavigationParams

        binding.bottomAppBar.fabCradleMargin = 10f
        binding.bottomAppBar.fabCradleRoundedCornerRadius = 2f
    }

    override fun onDestroy() {
        navController.removeOnDestinationChangedListener { _, _, _ -> }
        super.onDestroy()
    }

}