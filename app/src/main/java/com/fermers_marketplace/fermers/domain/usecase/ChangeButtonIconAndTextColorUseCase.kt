package com.fermers_marketplace.fermers.domain.usecase

import android.content.Context
import com.fermers_marketplace.fermers.presentation.activity.viewmodel.MainViewModel
import javax.inject.Inject

class ChangeButtonIconAndTextColorUseCase @Inject constructor() {
    fun execute(
        context: Context,
        buttonId: Int,
        textId: Int,
        newIconResId: Int,
        viewModel: MainViewModel
    ) {
        viewModel.changeButtonIconAndTextColorState(context, buttonId, textId, newIconResId)
    }

}