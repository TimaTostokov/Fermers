package com.fermers_marketplace.fermers.domain.usecase

import android.content.Context
import com.fermers_marketplace.fermers.presentation.activity.viewmodel.MainViewModel
import javax.inject.Inject

class ResetLastSelectedButtonUseCase @Inject constructor() {
    fun execute(context: Context, viewModel: MainViewModel) {
        viewModel.resetLastSelectedButtonState(context)
    }
}