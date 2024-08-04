package com.fermers_marketplace.fermers.presentation.fragments.catalog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.viewpager.widget.ViewPager
import com.fermers_marketplace.fermers.R
import com.fermers_marketplace.fermers.databinding.FragmentCatalogBinding
import com.fermers_marketplace.fermers.domain.usecase.ImageSliderUseCase
import com.fermers_marketplace.fermers.presentation.fragments.catalog.adapter.ImagePagerAdapter
import com.fermers_marketplace.fermers.presentation.fragments.catalog.viewmodel.ImageSliderViewModel
import com.fermers_marketplace.fermers.presentation.fragments.catalog.viewmodel.ImageSliderViewModelFactory
import kotlinx.coroutines.launch

class CatalogFragment : Fragment(R.layout.fragment_catalog) {

    private var _binding: FragmentCatalogBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ImageSliderViewModel by lazy {
        ViewModelProvider(
            this,
            ImageSliderViewModelFactory(ImageSliderUseCase())
        )[ImageSliderViewModel::class.java]
    }

    private val imageAdapter: ImagePagerAdapter by lazy {
        ImagePagerAdapter(requireContext(), viewModel.images)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCatalogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.imgSlider.adapter = imageAdapter

        lifecycleScope.launch {
            viewModel.currentItem.collect { position ->
                binding.imgSlider.currentItem = position
            }
        }

        lifecycleScope.launch {
            viewModel.canMoveNext.collect { canMoveNext ->
                binding.btnSlideRight.visibility = if (canMoveNext) View.VISIBLE else View.GONE
            }
        }

        lifecycleScope.launch {
            viewModel.canMovePrevious.collect { canMovePrevious ->
                binding.btnSlideLeft.visibility = if (canMovePrevious) View.VISIBLE else View.GONE
            }
        }

        binding.btnSlideRight.setOnClickListener {
            viewModel.moveNext()
        }

        binding.btnSlideLeft.setOnClickListener {
            viewModel.movePrevious()
        }

        val indicator = binding.slideDotLL
        indicator.setViewPager(binding.imgSlider)

        binding.imgSlider.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                viewModel.setCurrentItem(position)
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}