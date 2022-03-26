package com.example.powerdex.data.model

import com.google.gson.annotations.SerializedName

class Appearance {

    var gender = ""
    var race = ""
    var height = ArrayList<String>()
    var weight = ArrayList<String>()

    @field:SerializedName("eye-color")
    var eyeColor = ""

    @field:SerializedName("hair-color")
    var hairColor = ""

}