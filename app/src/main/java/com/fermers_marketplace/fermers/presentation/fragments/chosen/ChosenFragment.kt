package com.fermers_marketplace.fermers.presentation.fragments.chosen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.fermers_marketplace.fermers.databinding.FragmentChosenBinding
import com.fermers_marketplace.fermers.presentation.fragments.chosen.adapter.ChosenViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class ChosenFragment : Fragment() {

    private var _binding: FragmentChosenBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChosenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewPagerChosen.adapter = ChosenViewPagerAdapter(this)
        binding.apply {
            TabLayoutMediator(tabLayoutChosen, viewPagerChosen) { tab, position ->
                tab.text = when (position) {
                    0 -> "Куплю"
                    else -> "Продаю"
                }
            }.attach()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}