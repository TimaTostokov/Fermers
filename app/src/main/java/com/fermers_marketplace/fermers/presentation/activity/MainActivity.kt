package com.fermers_marketplace.fermers.presentation.activity

import android.os.Build
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.fermers_marketplace.fermers.R
import com.fermers_marketplace.fermers.data.api.model.ButtonConfig
import com.fermers_marketplace.fermers.databinding.ActivityMainBinding
import com.google.android.material.shape.MaterialShapeDrawable

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var lastSelectedButtonLayout: LinearLayout? = null
    private var lastSelectedButtonId: Int? = null
    private var lastSelectedTextId: Int? = null
    private var lastSelectedIconResId: Int? = null

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
                    bottomAppBar.apply { isVisible = true }
                    fab.apply { isVisible = true }
                    supportActionBar?.hide()
                } else {
                    bottomAppBar.apply { isVisible = false }
                    fab.apply { isVisible = false }
                    supportActionBar?.show()
                }
            }
        }

        buttonConfigs.forEach { config ->
            setupButtonClickListener(config)
        }

        selectInitialButton(buttonConfigs[0])
    }

    private fun setupBottomAppBarCornerRadius() {
        val radius = resources.getDimension(R.dimen.corner_radius)
        val bottomBarBackground = binding.bottomAppBar.background as MaterialShapeDrawable
        bottomBarBackground.shapeAppearanceModel =
            bottomBarBackground.shapeAppearanceModel.toBuilder()
                .setAllCornerSizes(radius)
                .build()
    }

    private fun setupButtonClickListener(config: ButtonConfig) {
        findViewById<LinearLayout>(config.layoutId).setOnClickListener {
            it.startAnimation(AnimationUtils.loadAnimation(this, R.anim.alpha))
            resetLastSelectedButton()
            lastSelectedIconResId = config.defaultIconResId
            changeButtonIconAndTextColor(config.buttonId, config.textId, config.newIconResId)
            lastSelectedButtonLayout = findViewById(config.layoutId)
            lastSelectedButtonId = config.buttonId
            lastSelectedTextId = config.textId
            navController.navigate(config.fragmentId)
        }
    }

    private fun selectInitialButton(config: ButtonConfig) {
        changeButtonIconAndTextColor(config.buttonId, config.textId, config.newIconResId)
        lastSelectedButtonLayout = findViewById(config.layoutId)
        lastSelectedButtonId = config.buttonId
        lastSelectedTextId = config.textId
        lastSelectedIconResId = config.defaultIconResId
    }

    private fun resetLastSelectedButton() {
        lastSelectedButtonLayout.let {
            findViewById<ImageButton>(lastSelectedButtonId!!).setImageDrawable(
                ContextCompat.getDrawable(this, lastSelectedIconResId!!)
            )
            findViewById<TextView>(lastSelectedTextId!!).setTextColor(
                ContextCompat.getColor(this, R.color.gray)
            )
        }
    }

    private fun changeButtonIconAndTextColor(buttonId: Int, textId: Int, newIconResId: Int) {
        findViewById<ImageButton>(buttonId).setImageDrawable(
            ContextCompat.getDrawable(this, newIconResId)
        )
        findViewById<TextView>(textId).setTextColor(
            ContextCompat.getColor(this, R.color.colorWhite)
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        navController.removeOnDestinationChangedListener { _, _, _ -> }
        lastSelectedButtonLayout = null
    }

}