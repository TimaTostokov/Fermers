package com.fermers_marketplace.fermers.presentation.fragments.catalog.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.fermers_marketplace.fermers.domain.usecase.ImageSliderUseCase

class ImageSliderViewModelFactory(private val useCase: ImageSliderUseCase) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ImageSliderViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ImageSliderViewModel(useCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}