package com.example.powerdex.menu

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.powerdex.R
import com.example.powerdex.adapter.MenuHeroAdapter
import com.example.powerdex.base.BaseFragment
import com.example.powerdex.base.DroidApp
import com.example.powerdex.data.model.InfoSuperHero
import com.example.powerdex.data.repository.SuperHeroRepository
import com.example.powerdex.databinding.ViewMenuFragmentBinding


class MenuFragment : BaseFragment<ViewMenuFragmentBinding>(R.layout.view_menu_fragment),
    MenuViewModel.MenuData {

    private lateinit var binding: ViewMenuFragmentBinding
    private val retrofit = DroidApp.getRetrofitSuperhero()
    private lateinit var menuViewModel: MenuViewModel
    private lateinit var adapter: MenuHeroAdapter
    private var isLoading = false

    override fun ViewMenuFragmentBinding.initialize() {
        binding = this
        setUpViewModel()
        setRecycler()
        menuViewModel.getDataHero()
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


    private fun setRecycler() {

        menuViewModel.getListHero().observe(this, Observer { arrayHeroes ->
            adapter = MenuHeroAdapter(arrayHeroes) {
                InfoSuperHero.getInstance().setSuperHero(it)
                findNavController().navigate(R.id.action_menuFragment_to_infoHeroFragment)
            }

            binding.rvListHero.layoutManager = LinearLayoutManager(activity)
            binding.rvListHero.adapter = adapter
            adapter.notifyDataSetChanged()
        })

    }


}