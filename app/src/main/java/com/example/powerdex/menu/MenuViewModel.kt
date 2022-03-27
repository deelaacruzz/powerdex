package com.example.powerdex.menu

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.powerdex.data.model.SuperHeroModel
import com.example.powerdex.data.repository.SuperHeroRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MenuViewModel(
    private val superHeroRepository: SuperHeroRepository,
    private val menuInterface: MenuData
) : ViewModel() {


    private var listHero = MutableLiveData<ArrayList<SuperHeroModel>>(arrayListOf())

    private var loadHero = 0
    private var maxHeroLoad = 10

    fun getListHero(): MutableLiveData<ArrayList<SuperHeroModel>> = listHero

    fun getDataHero() {
        loadHero++
        menuInterface.showProgress()
        viewModelScope.launch {
            val responseHero = withContext(Dispatchers.IO) {
                superHeroRepository.getSuperHero(loadHero.toString()).execute()
            }
            val superHero = responseHero.body()
            if (superHero != null) {
                listHero.value?.add(superHero)
            }

            if (loadHero <= maxHeroLoad) {
                getDataHero()
            } else {
                listHero.postValue(listHero.value)
                maxHeroLoad = maxHeroLoad + 10
                menuInterface.hideProgress()
            }
        }


    }


    interface MenuData {
       fun showProgress()
       fun hideProgress()
    }
}