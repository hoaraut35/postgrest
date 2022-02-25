package com.hoarauthomas.postgrest.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hoarauthomas.postgrest.api.Postgrestapi
import com.hoarauthomas.postgrest.models.CarsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class PostgreRepository @Inject constructor(private val postgresql: Postgrestapi) {

    private var mutableLiveDataOfCars = MutableLiveData<CarsResponse>()

    fun liveCars(): LiveData<CarsResponse> {
        return mutableLiveDataOfCars
    }

    fun getCars() {
        postgresql.getAllCars().enqueue(object : Callback<CarsResponse> {
            override fun onResponse(call: Call<CarsResponse>, response: Response<CarsResponse>) {
                if (response.isSuccessful) {
                    mutableLiveDataOfCars.value = response.body()
                }
            }

            override fun onFailure(call: Call<CarsResponse>, t: Throwable) {
                //TODO("Not yet implemented")
            }

        }
        )
    }

}