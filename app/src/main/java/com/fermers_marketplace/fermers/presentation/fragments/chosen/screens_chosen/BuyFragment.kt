package com.fermers_marketplace.fermers.presentation.fragments.chosen.screens_chosen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.fermers_marketplace.fermers.R
import com.fermers_marketplace.fermers.data.model.AdvertModel
import com.fermers_marketplace.fermers.databinding.FragmentBuyBinding
import com.fermers_marketplace.fermers.common.ScrollToTopListener
import com.fermers_marketplace.fermers.presentation.fragments.chosen.adapter.AdvertAdapter

class BuyFragment : Fragment(), ScrollToTopListener {

    private var _binding: FragmentBuyBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBuyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val items = listOf(
            AdvertModel(R.drawable.cow, "Куплю корову", "Цена 80тыс"),
            AdvertModel(R.drawable.ram, "Куплю барана", "Цена 50тыс"),
            AdvertModel(R.drawable.horse, "Куплю лошадь", "Цена 120тыс"),
            AdvertModel(R.drawable.cow, "Куплю корову", "Цена 80тыс"),
            AdvertModel(R.drawable.ram, "Куплю барана", "Цена 50тыс"),
            AdvertModel(R.drawable.horse, "Куплю лошадь", "Цена 120тыс"),
            AdvertModel(R.drawable.cow, "Куплю корову", "Цена 80тыс"),
            AdvertModel(R.drawable.ram, "Куплю барана", "Цена 50тыс"),
            AdvertModel(R.drawable.horse, "Куплю лошадь", "Цена 120тыс"),
            AdvertModel(R.drawable.cow, "Куплю корову", "Цена 80тыс"),
            AdvertModel(R.drawable.ram, "Куплю барана", "Цена 50тыс"),
            AdvertModel(R.drawable.horse, "Куплю лошадь", "Цена 120тыс"),
            AdvertModel(R.drawable.cow, "Куплю корову", "Цена 80тыс"),
            AdvertModel(R.drawable.ram, "Куплю барана", "Цена 50тыс"),
            AdvertModel(R.drawable.horse, "Куплю лошадь", "Цена 120тыс"),
            AdvertModel(R.drawable.cow, "Куплю корову", "Цена 80тыс"),
            AdvertModel(R.drawable.ram, "Куплю барана", "Цена 50тыс"),
            AdvertModel(R.drawable.horse, "Куплю лошадь", "Цена 120тыс"),
            AdvertModel(R.drawable.cow, "Куплю корову", "Цена 80тыс"),
            AdvertModel(R.drawable.ram, "Куплю барана", "Цена 50тыс"),
            AdvertModel(R.drawable.horse, "Куплю лошадь", "Цена 120тыс"),
        )

        val adapter = AdvertAdapter(items)
        binding.rvBuy.adapter = adapter
        binding.rvBuy.layoutManager = GridLayoutManager(requireContext(), 2)

    }

    override fun scrollToTop() {
        binding.rvBuy.smoothScrollToPosition(0)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}