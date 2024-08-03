package com.fermers_marketplace.fermers.presentation.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.fermers_marketplace.fermers.databinding.FragmentHomeBinding
import com.fermers_marketplace.common.ScrollToTopListener
import com.fermers_marketplace.fermers.presentation.fragments.home.adapter.HomeViewPagerAdapter
import com.fermers_marketplace.fermers.utils.ext.Extension
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment : Fragment(), ScrollToTopListener {

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

        goToSearch()

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

    private fun goToSearch() {
        binding.etSearch.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToSearchFragment())
        }
    }

    override fun scrollToTop() {
        val currentFragment = (binding.viewPagerHome.adapter as HomeViewPagerAdapter)
            .getFragmentAt(binding.viewPagerHome.currentItem)

        if (currentFragment is ScrollToTopListener) {
            if (currentFragment.isAdded && currentFragment.view != null) {
                currentFragment.scrollToTop()
            } else {
                Extension.showToast(requireContext(),"Error: Fragment")
            }
        } else {
            Extension.showToast(requireContext(),"Current fragment is not an instance of ScrollToTopListener.")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}