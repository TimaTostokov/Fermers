package com.fermers_marketplace.fermers.presentation.fragments.home.screens_home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.fermers_marketplace.fermers.R
import com.fermers_marketplace.fermers.data.model.AdvertModel
import com.fermers_marketplace.fermers.databinding.FragmentRecommendationBinding
import com.fermers_marketplace.fermers.presentation.fragments.chosen.adapter.AdvertAdapter

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

        val items = mutableListOf(
            AdvertModel(R.drawable.horse, "Продаю лошадь", "Цена 120тыс"),
            AdvertModel(R.drawable.cow, "Продаю корову", "Цена 80тыс"),
            AdvertModel(R.drawable.ram, "Продаю барана", "Цена 50тыс"),
            AdvertModel(R.drawable.horse, "Продаю лошадь", "Цена 120тыс"),
            AdvertModel(R.drawable.cow, "Продаю корову", "Цена 80тыс"),
            AdvertModel(R.drawable.ram, "Продаю барана", "Цена 50тыс"),
            AdvertModel(R.drawable.horse, "Продаю лошадь", "Цена 120тыс"),
            AdvertModel(R.drawable.cow, "Продаю корову", "Цена 80тыс"),
            AdvertModel(R.drawable.ram, "Продаю барана", "Цена 50тыс"),
            AdvertModel(R.drawable.horse, "Продаю лошадь", "Цена 120тыс"),
            AdvertModel(R.drawable.cow, "Продаю корову", "Цена 80тыс"),
            AdvertModel(R.drawable.ram, "Продаю барана", "Цена 50тыс"),
            AdvertModel(R.drawable.horse, "Продаю лошадь", "Цена 120тыс"),
            AdvertModel(R.drawable.cow, "Продаю корову", "Цена 80тыс"),
            AdvertModel(R.drawable.ram, "Продаю барана", "Цена 50тыс"),
            AdvertModel(R.drawable.horse, "Продаю лошадь", "Цена 120тыс"),
            AdvertModel(R.drawable.cow, "Продаю корову", "Цена 80тыс"),
            AdvertModel(R.drawable.ram, "Продаю барана", "Цена 50тыс"),
            AdvertModel(R.drawable.horse, "Продаю лошадь", "Цена 120тыс"),
            AdvertModel(R.drawable.cow, "Продаю корову", "Цена 80тыс"),
            AdvertModel(R.drawable.ram, "Продаю барана", "Цена 50тыс"),

            )

        val adapter = AdvertAdapter(items)
        binding.rvBuyHome.adapter = adapter
        binding.rvBuyHome.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.rvBuyHome.adapter = adapter

    }

}