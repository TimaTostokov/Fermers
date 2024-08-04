package com.fermers_marketplace.fermers.presentation.fragments.catalog.viewmodel

import androidx.lifecycle.ViewModel
import com.fermers_marketplace.fermers.domain.usecase.ImageSliderUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ImageSliderViewModel(private val useCase: ImageSliderUseCase) : ViewModel() {

    private val _currentItem = MutableStateFlow(0)
    val currentItem: StateFlow<Int> get() = _currentItem

    private val _canMoveNext = MutableStateFlow(true)
    val canMoveNext: StateFlow<Boolean> get() = _canMoveNext

    private val _canMovePrevious = MutableStateFlow(false)
    val canMovePrevious: StateFlow<Boolean> get() = _canMovePrevious

    val images: List<Int> = useCase.getImages()

    fun moveNext() {
        _currentItem.value.let {
            if (useCase.canMoveNext(it)) {
                _currentItem.value = it + 1
                updateButtonVisibility()
            }
        }
    }

    fun movePrevious() {
        _currentItem.value.let {
            if (useCase.canMovePrevious(it)) {
                _currentItem.value = it - 1
                updateButtonVisibility()
            }
        }
    }

    fun setCurrentItem(position: Int) {
        _currentItem.value = position
        updateButtonVisibility()
    }

    private fun updateButtonVisibility() {
        _currentItem.value.let {
            _canMoveNext.value = useCase.canMoveNext(it)
            _canMovePrevious.value = useCase.canMovePrevious(it)
        }
    }

}