package com.example.powerdex.data.repository

import com.example.powerdex.data.api.SuperHeroService
import com.example.powerdex.data.model.SuperHeroModel
import retrofit2.Call

class SuperHeroRepository(private val superHeroService: SuperHeroService) {

    fun getSuperHero(idHero: String): Call<SuperHeroModel> = superHeroService.getSuperHeroId(idHero)

}