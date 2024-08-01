package com.fermers_marketplace.fermers.presentation.fragments.home.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.fermers_marketplace.fermers.presentation.fragments.chosen.screens_chosen.BuyFragment
import com.fermers_marketplace.fermers.presentation.fragments.chosen.screens_chosen.SellFragment
import com.fermers_marketplace.fermers.presentation.fragments.home.screens_home.FollowersFragment
import com.fermers_marketplace.fermers.presentation.fragments.home.screens_home.RecommendationFragment

class HomeViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> FollowersFragment()
            else -> RecommendationFragment()
        }
    }

}