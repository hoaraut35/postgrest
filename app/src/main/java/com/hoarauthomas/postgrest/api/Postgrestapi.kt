package com.hoarauthomas.postgrest.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Postgrestapi {

    @GET("cars")
    fun getAllCars(@Query("address") address: String): Call<Cars>
}