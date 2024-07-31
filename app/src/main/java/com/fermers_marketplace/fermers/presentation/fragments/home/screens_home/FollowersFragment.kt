package com.fermers_marketplace.fermers.presentation.fragments.home.screens_home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fermers_marketplace.fermers.R
import com.fermers_marketplace.fermers.data.api.model.AdvertModel
import com.fermers_marketplace.fermers.databinding.FragmentBuyBinding
import com.fermers_marketplace.fermers.databinding.FragmentFollowersBinding
import com.fermers_marketplace.fermers.presentation.fragments.chosen.adapter.AdvertAdapter
import com.fermers_marketplace.fermers.presentation.fragments.home.adapter.AdvertHomeAdapter

class FollowersFragment : Fragment() {

    private var _binding: FragmentFollowersBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFollowersBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val items = listOf(
            AdvertModel(R.drawable.pattern_image, "Жыкы Байке не нахуй", "Цена 120 cом"),
            AdvertModel(R.drawable.onboard_one, "Рамис продаю ноутбук", "Цена 200 сом"),
            AdvertModel(R.drawable.onboard_three, "Продаю там", "Цена 300 сом")
        )

        val adapter = AdvertHomeAdapter(items)
        binding.rvBuyHome.adapter = adapter
    }

}