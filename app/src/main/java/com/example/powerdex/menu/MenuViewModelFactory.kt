package com.example.powerdex.menu

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.powerdex.data.repository.SuperHeroRepository

class MenuViewModelFactory (
    private val superHeroRepository: SuperHeroRepository,
    private val menuInterface: MenuViewModel.MenuData
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MenuViewModel::class.java)) {
            MenuViewModel(this.superHeroRepository, menuInterface) as T
        } else throw IllegalArgumentException("No se encontró la clase")
    }
}