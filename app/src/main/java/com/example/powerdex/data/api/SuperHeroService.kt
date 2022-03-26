package com.example.powerdex.data.api

import com.example.powerdex.data.model.SuperHeroModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface SuperHeroService {

    @Headers("Content-Type: application/json")
    @GET("{id}/")
    fun getSuperHeroId(
        @Path(value = "id") id: String
    ): Call<SuperHeroModel>
}