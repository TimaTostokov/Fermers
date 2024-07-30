package com.fermers_marketplace.fermers.presentation.fragments.chosen.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.fermers_marketplace.fermers.presentation.fragments.chosen.screens.BuyFragment
import com.fermers_marketplace.fermers.presentation.fragments.chosen.screens.SellFragment

class ChosenViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> BuyFragment()
            else -> SellFragment()
        }
    }

}