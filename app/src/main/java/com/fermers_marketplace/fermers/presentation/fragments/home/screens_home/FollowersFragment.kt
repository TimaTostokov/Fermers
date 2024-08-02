package com.fermers_marketplace.fermers.presentation.fragments.home.screens_home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.fermers_marketplace.fermers.R
import com.fermers_marketplace.fermers.data.model.AdvertModel
import com.fermers_marketplace.fermers.databinding.FragmentFollowersBinding
import com.fermers_marketplace.common.ScrollToTopListener
import com.fermers_marketplace.fermers.presentation.fragments.home.adapter.AdvertHomeAdapter

class FollowersFragment : Fragment(), ScrollToTopListener {

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
        binding.rvBuyHome.layoutManager = GridLayoutManager(requireContext(), 2)

    }

    override fun scrollToTop() {
        binding.rvBuyHome.smoothScrollToPosition(0)
    }

}