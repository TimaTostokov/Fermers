package com.fermers_marketplace.fermers.domain.usecase

import com.fermers_marketplace.fermers.R

class ImageSliderUseCase {

    private val images = listOf(
        R.drawable.background_onboarding_one,
        R.drawable.background_onboarding_third,
        R.drawable.onboard_two,
        R.drawable.background_onboarding_two,
        R.drawable.onboard_one,
        R.drawable.onboard_three,
    )

    fun getImages(): List<Int> = images

    fun canMoveNext(currentItem: Int): Boolean = currentItem < images.size - 1

    fun canMovePrevious(currentItem: Int): Boolean = currentItem > 0
}