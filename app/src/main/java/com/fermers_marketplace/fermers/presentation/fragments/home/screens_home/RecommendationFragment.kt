package com.fermers_marketplace.fermers.presentation.fragments.home.screens_home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.fermers_marketplace.fermers.R
import com.fermers_marketplace.fermers.data.api.model.AdvertModel
import com.fermers_marketplace.fermers.databinding.FragmentRecommendationBinding
import com.fermers_marketplace.fermers.presentation.fragments.chosen.adapter.AdvertAdapter
import com.fermers_marketplace.fermers.presentation.fragments.home.adapter.AdvertHomeAdapter

class RecommendationFragment : Fragment() {

    private var _binding: FragmentRecommendationBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRecommendationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val items = listOf(
            AdvertModel(R.mipmap.ic_launcher, "fer", "Цена 1"),
            AdvertModel(R.drawable.pattern_image, "Описание 2", "Цена 2"),
            AdvertModel(R.mipmap.ic_launcher, "Описание 3", "Цена 33dollar")
        )

        val adapter = AdvertHomeAdapter(items)
        binding.rvBuyHome.adapter = adapter

    }

}