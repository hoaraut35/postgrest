package com.hoarauthomas.postgrest.api

import com.hoarauthomas.postgrest.models.CarsResponse
import com.hoarauthomas.postgrest.models.CarsResponseItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Postgrestapi {

    @GET("cars")
    fun getAllCars(): Call<List<CarsResponseItem>>
}