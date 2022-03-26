package com.example.powerdex.splash

import android.annotation.SuppressLint
import android.os.Handler
import android.os.Looper
import androidx.navigation.fragment.findNavController
import com.example.powerdex.R
import com.example.powerdex.base.BaseFragment
import com.example.powerdex.databinding.ViewSplashBinding


@SuppressLint("CustomSplashScreen")
class SplashFragment : BaseFragment<ViewSplashBinding>(R.layout.view_splash) {

    private lateinit var binding: ViewSplashBinding
    override fun ViewSplashBinding.initialize() {
        binding = this

        Handler(Looper.getMainLooper()).postDelayed({
            findNavController().navigate(R.id.action_splashFragment_to_menuFragment)

        }, 4000)
    }

}