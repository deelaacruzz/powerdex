package com.example.powerdex.menu

import android.content.Context
import android.graphics.Rect
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.powerdex.R
import com.example.powerdex.adapter.MenuHeroAdapter
import com.example.powerdex.base.BaseFragment
import com.example.powerdex.base.DroidApp
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
        setRecycler()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        setUpViewModel()
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
                findNavController().navigate(R.id.action_menuFragment_to_infoHeroFragment)
            }

            binding.rvListHero.layoutManager = LinearLayoutManager(activity)
            binding.rvListHero.adapter = adapter
            adapter.notifyDataSetChanged()
            isLoading = false

        })


        binding.rvListHero.addOnScrollListener(object : RecyclerView.OnScrollListener() {

            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!recyclerView.canScrollVertically(1)) {
                    validarFinalView(binding.separador)
                }
            }

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
            }
        })
    }

    fun validarFinalView(view: View) {
        val scrollBounds = Rect()
        binding.nscroll.getHitRect(scrollBounds)
        if (view.getLocalVisibleRect(scrollBounds)) {

            if (!isLoading) {
                menuViewModel.getDataHero()
                isLoading = true
                Log.i("MenuFragment", "Inicia carga de datos");
            } else {
                Log.i("MenuFragment", "cargando datos...");
            }


        } else {
            Log.i("MenuFragment", "Sin Carga de datos");
        }

    }

    override fun showProgress() {
        showProgresDialog()
    }

    override fun hideProgress() {
        hideProgressDialog()
    }


}