package com.fermers_marketplace.fermers.presentation.fragments.chosen.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.fermers_marketplace.fermers.presentation.fragments.chosen.screens_chosen.BuyFragment
import com.fermers_marketplace.fermers.presentation.fragments.chosen.screens_chosen.SellFragment

class ChosenViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    private val fragments: List<Fragment> = listOf(BuyFragment(), SellFragment())

    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }

    fun getFragmentAt(position: Int): Fragment {
        return fragments[position]
    }

}