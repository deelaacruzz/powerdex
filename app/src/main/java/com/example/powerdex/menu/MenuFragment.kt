package com.example.powerdex.menu

import androidx.lifecycle.ViewModelProvider
import com.example.powerdex.R
import com.example.powerdex.base.BaseFragment
import com.example.powerdex.base.DroidApp
import com.example.powerdex.data.repository.SuperHeroRepository
import com.example.powerdex.databinding.ViewMenuFragmentBinding

class MenuFragment : BaseFragment<ViewMenuFragmentBinding>(R.layout.view_menu_fragment),
    MenuViewModel.MenuData {

    private lateinit var binding: ViewMenuFragmentBinding
    private val retrofit = DroidApp.getRetrofitSuperhero()
    private lateinit var menuViewModel: MenuViewModel

    override fun ViewMenuFragmentBinding.initialize() {
        binding = this
        setUpViewModel()
    }


    /**
     * Inicializa el ViewModel
     */
    private fun setUpViewModel() {
        menuViewModel = ViewModelProvider(
            this,
            MenuViewModelFactory(
                SuperHeroRepository(retrofit),
                this
            )
        ).get(MenuViewModel::class.java)
    }

}