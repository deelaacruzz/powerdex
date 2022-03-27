package com.example.powerdex.menu.infoHeroe

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.powerdex.data.model.InfoSuperHero


class InfoHeroViewModel : ViewModel() {

    private var infoHero = MutableLiveData(InfoSuperHero.getInstance())

    fun getHero(): MutableLiveData<InfoSuperHero> = infoHero
}