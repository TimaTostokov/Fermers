package com.fermers_marketplace.fermers.domain.usecase

import android.content.Context
import android.widget.LinearLayout
import com.fermers_marketplace.fermers.data.model.ButtonConfig
import com.fermers_marketplace.fermers.presentation.activity.viewmodel.MainViewModel

class SelectInitialButtonUseCase {
    fun execute(
        context: Context,
        layout: LinearLayout,
        config: ButtonConfig,
        viewModel: MainViewModel
    ) {
        viewModel.updateSelectedButtonState(layout, config)
        viewModel.changeButtonIconAndTextColor(context, config.buttonId, config.textId, config.newIconResId)
    }

}