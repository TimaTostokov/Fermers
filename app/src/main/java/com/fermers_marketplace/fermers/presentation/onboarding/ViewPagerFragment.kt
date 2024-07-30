package com.fermers_marketplace.fermers.presentation.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.fermers_marketplace.fermers.R
import com.fermers_marketplace.fermers.databinding.FragmentViewPagerBinding
import com.fermers_marketplace.fermers.presentation.onboarding.adapter.ViewPagerAdapter
import com.fermers_marketplace.fermers.presentation.onboarding.screens.FirstScreenFragment
import com.fermers_marketplace.fermers.presentation.onboarding.screens.SecondScreenFragment
import com.fermers_marketplace.fermers.presentation.onboarding.screens.ThirdScreenFragment

class ViewPagerFragment : Fragment() {

    private lateinit var binding: FragmentViewPagerBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentViewPagerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fragmentList = arrayListOf<Fragment>(
            FirstScreenFragment(),
            SecondScreenFragment(),
            ThirdScreenFragment()
        )

        val adapter = ViewPagerAdapter(
            requireActivity().supportFragmentManager,
            lifecycle,
            fragmentList
        )

        binding.vpOnboarding.adapter = adapter
        binding.dotsIndicator.attachTo(binding.vpOnboarding)

        initListener()
    }

    private fun initListener() {
        val viewPager = activity?.findViewById<ViewPager2>(R.id.vp_onboarding)
        binding.btnSkip.setOnClickListener {
            viewPager?.currentItem = 2
        }
    }

}