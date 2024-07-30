package com.fermers_marketplace.fermers.presentation.fragments.chosen.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.fermers_marketplace.fermers.R
import com.fermers_marketplace.fermers.data.api.model.AdvertModel
import com.fermers_marketplace.fermers.databinding.FragmentSellBinding
import com.fermers_marketplace.fermers.presentation.fragments.chosen.adapter.AdvertAdapter

class SellFragment : Fragment() {

    private var _binding: FragmentSellBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSellBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val items = listOf(
            AdvertModel(R.mipmap.ic_launcher, "Описание 1", "Цена 1"),
            AdvertModel(R.mipmap.ic_launcher, "Описание 2", "Цена 2"),
            AdvertModel(R.mipmap.ic_launcher, "Описание 3", "Цена 3")
        )

        val adapter = AdvertAdapter(items)
        binding.rvBuy.adapter = adapter

    }

}