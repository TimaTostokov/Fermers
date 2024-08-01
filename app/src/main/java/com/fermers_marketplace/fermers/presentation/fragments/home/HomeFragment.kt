package com.fermers_marketplace.fermers.presentation.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.fermers_marketplace.fermers.databinding.FragmentHomeBinding
import com.fermers_marketplace.fermers.presentation.fragments.chosen.adapter.ChosenViewPagerAdapter
import com.fermers_marketplace.fermers.presentation.fragments.home.adapter.HomeViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewPagerHome.adapter = HomeViewPagerAdapter(this)
        binding.apply {
            TabLayoutMediator(tabLayoutHome, viewPagerHome) { tab, position ->
                tab.text = when (position) {
                    0 -> "Рекомендации"
                    else -> "Подписка"
                }
            }.attach()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}