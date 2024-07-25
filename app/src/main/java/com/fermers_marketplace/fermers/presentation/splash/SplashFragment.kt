package com.fermers_marketplace.fermers.presentation.splash

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.fermers_marketplace.fermers.R
import com.fermers_marketplace.fermers.databinding.FragmentSplashBinding
import com.fermers_marketplace.fermers.utils.extension.viewBinding

class SplashFragment : Fragment(R.layout.fragment_splash) {

    private val binding by viewBinding(FragmentSplashBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}