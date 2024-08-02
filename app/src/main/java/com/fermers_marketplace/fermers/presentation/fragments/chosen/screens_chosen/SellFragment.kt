package com.fermers_marketplace.fermers.presentation.fragments.chosen.screens_chosen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.fermers_marketplace.fermers.R
import com.fermers_marketplace.fermers.data.model.AdvertModel
import com.fermers_marketplace.fermers.databinding.FragmentSellBinding
import com.fermers_marketplace.common.ScrollToTopListener
import com.fermers_marketplace.fermers.presentation.fragments.chosen.adapter.AdvertAdapter

class SellFragment : Fragment(), ScrollToTopListener {

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
            AdvertModel(R.drawable.ram, "Продаю лошадь", "Цена 120тыс"),
            AdvertModel(R.drawable.cow, "Продаю корову", "Цена 80тыс"),
            AdvertModel(R.drawable.horse, "Продаю барана", "Цена 50тыс"),
            AdvertModel(R.drawable.ram, "Продаю лошадь", "Цена 120тыс"),
            AdvertModel(R.drawable.cow, "Продаю корову", "Цена 80тыс"),
            AdvertModel(R.drawable.horse, "Продаю барана", "Цена 50тыс"),
            AdvertModel(R.drawable.ram, "Продаю лошадь", "Цена 120тыс"),
            AdvertModel(R.drawable.cow, "Продаю корову", "Цена 80тыс"),
            AdvertModel(R.drawable.horse, "Продаю барана", "Цена 50тыс"),
            AdvertModel(R.drawable.ram, "Продаю лошадь", "Цена 120тыс"),
            AdvertModel(R.drawable.cow, "Продаю корову", "Цена 80тыс"),
            AdvertModel(R.drawable.horse, "Продаю барана", "Цена 50тыс"),
            AdvertModel(R.drawable.ram, "Продаю лошадь", "Цена 120тыс"),
            AdvertModel(R.drawable.cow, "Продаю корову", "Цена 80тыс"),
            AdvertModel(R.drawable.horse, "Продаю барана", "Цена 50тыс"),
            AdvertModel(R.drawable.ram, "Продаю лошадь", "Цена 120тыс"),
            AdvertModel(R.drawable.cow, "Продаю корову", "Цена 80тыс"),
            AdvertModel(R.drawable.horse, "Продаю барана", "Цена 50тыс"),
            AdvertModel(R.drawable.ram, "Продаю лошадь", "Цена 120тыс"),
            AdvertModel(R.drawable.cow, "Продаю корову", "Цена 80тыс"),
            AdvertModel(R.drawable.horse, "Продаю барана", "Цена 50тыс"),
        )

        val adapter = AdvertAdapter(items)
        binding.rvSell.adapter = adapter
        binding.rvSell.layoutManager = GridLayoutManager(requireContext(), 2)

    }

    override fun scrollToTop() {
        binding.rvSell.smoothScrollToPosition(0)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}