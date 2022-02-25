package com.hoarauthomas.postgrest.api

import com.hoarauthomas.postgrest.models.CarsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Postgrestapi {

    @GET("cars")
    fun getAllCars(): Call<CarsResponse>
}