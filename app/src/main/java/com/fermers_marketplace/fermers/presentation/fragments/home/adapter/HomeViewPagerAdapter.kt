package com.fermers_marketplace.fermers.presentation.fragments.home.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.fermers_marketplace.fermers.presentation.fragments.home.screens_home.FollowersFragment
import com.fermers_marketplace.fermers.presentation.fragments.home.screens_home.RecommendationFragment

class HomeViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    private val fragments: List<Fragment> = listOf(RecommendationFragment(), FollowersFragment())

    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }

    fun getFragmentAt(position: Int): Fragment {
        return fragments[position]
    }

}