package com.fermers_marketplace.fermers.presentation.splash

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.fermers_marketplace.fermers.R
import com.fermers_marketplace.fermers.databinding.FragmentSplashBinding
import com.fermers_marketplace.fermers.utils.ext.viewBinding

class SplashFragment : Fragment(R.layout.fragment_splash) {

    private val binding by viewBinding(FragmentSplashBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Handler(Looper.getMainLooper()).postDelayed({
            if (shouldShowOnBoarding()) {
                findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToHomeFragment())
            } else {
                findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToViewPagerFragment())
            }
        }, 2500)

        val animTop =
            android.view.animation.AnimationUtils.loadAnimation(view.context, R.anim.from_top)
        val animBottom =
            android.view.animation.AnimationUtils.loadAnimation(view.context, R.anim.from_bottom)

        val tvSplash = view.findViewById<TextView>(R.id.tvSplash)
        val tvSplashc = view.findViewById<TextView>(R.id.tvSplashc)

        tvSplash.animation = animBottom
        tvSplashc.animation = animTop

        activity?.window?.let { window ->
            window.navigationBarColor =
                ContextCompat.getColor(requireContext(), R.color.white_green)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        activity?.window?.let { window ->
            window.navigationBarColor =
                ContextCompat.getColor(requireContext(), R.color.white_green)
        }
    }

    private fun shouldShowOnBoarding(): Boolean {
        val sharedPreferences =
            requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        return sharedPreferences.getBoolean("finished", false)
    }

}