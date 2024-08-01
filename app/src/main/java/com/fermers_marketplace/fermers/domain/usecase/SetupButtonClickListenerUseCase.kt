package com.fermers_marketplace.fermers.domain.usecase

import android.content.Context
import android.widget.LinearLayout
import androidx.navigation.NavController
import com.fermers_marketplace.fermers.data.model.ButtonConfig
import com.fermers_marketplace.fermers.presentation.activity.viewmodel.MainViewModel

class SetupButtonClickListenerUseCase {
    fun execute(
        context: Context,
        layout: LinearLayout,
        config: ButtonConfig,
        navController: NavController,
        viewModel: MainViewModel
    ) {
        viewModel.resetLastSelectedButton(context)
        viewModel.updateSelectedButtonState(layout, config)
        viewModel.changeButtonIconAndTextColor(context, config.buttonId, config.textId, config.newIconResId)
        navController.navigate(config.fragmentId)
    }
}
