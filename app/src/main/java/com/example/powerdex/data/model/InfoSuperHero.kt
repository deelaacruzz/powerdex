package com.example.powerdex.data.model

class InfoSuperHero : SuperHeroModel() {

    fun setSuperHero(hero: SuperHeroModel) {
        name = hero.name
        powerstats = hero.powerstats
        biography = hero.biography
        appearance = hero.appearance
        work = hero.work
        connections = hero.connections
        image = hero.image
    }

    companion object {
        @Volatile
        @JvmStatic
        private var INSTANCE: InfoSuperHero? = null

        @JvmStatic
        @JvmOverloads
        fun getInstance(): InfoSuperHero = INSTANCE ?: synchronized(this) {
            INSTANCE ?: InfoSuperHero().also { INSTANCE = it }
        }
    }

    fun destroy() {
        INSTANCE = null
    }


}