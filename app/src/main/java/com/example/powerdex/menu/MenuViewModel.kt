package com.example.powerdex.menu

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.powerdex.data.repository.SuperHeroRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MenuViewModel(private val superHeroRepository: SuperHeroRepository, private val menuInterface: MenuData) : ViewModel() {


    fun getInfoHero(id: String){
        viewModelScope.launch {

           val superHero = withContext(Dispatchers.IO) {
                superHeroRepository.getSuperHero(id).execute()
            }


        }
    }



    interface MenuData {

    }
}