package com.example.powerdex.menu

import com.example.powerdex.R
import com.example.powerdex.base.BaseFragment
import com.example.powerdex.databinding.ViewMenuFragmentBinding

class MenuFragment:BaseFragment<ViewMenuFragmentBinding>(R.layout.view_menu_fragment) {

    private lateinit var binding: ViewMenuFragmentBinding

    override fun ViewMenuFragmentBinding.initialize() {
        binding = this

    }


}