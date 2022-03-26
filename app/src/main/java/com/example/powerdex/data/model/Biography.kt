package com.example.powerdex.data.model

import com.google.gson.annotations.SerializedName

class Biography {
    @field:SerializedName("full-name")
    var fullName = ""

    @field:SerializedName("alter-egos")
    var alterEgos = ""

    var aliases = ArrayList<String>()

    @field:SerializedName("place-of-birth")
    var placeOfBirth = ""

    @field:SerializedName("first-appearance")
    var firstAppearance = ""

    var publisher = ""
    var alignment = ""
}