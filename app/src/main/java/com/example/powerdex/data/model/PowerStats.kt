package com.example.powerdex.data.model

class PowerStats {

    private var intelligence = ""
    private var strength = "0"
    private var speed = "0"
    private var durability = "0"
    private var power = "0"
    private var combat = "0"



    fun getIntelligence() = if(intelligence == "null") "0" else intelligence
    fun getStrength() = if(strength == "null") "0" else strength
    fun getSpeed() = if(speed == "null") "0" else speed
    fun getDurability() = if(durability == "null") "0" else durability
    fun getPower() = if(power == "null") "0" else power
    fun getCombat() = if(combat == "null") "0" else combat
}