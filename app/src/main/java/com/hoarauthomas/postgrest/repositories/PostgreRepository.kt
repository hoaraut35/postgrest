package com.hoarauthomas.postgrest.repositories

import android.util.Log
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

    private var mutableLiveDataOfCars = MutableLiveData<List<CarsResponse>>()

    fun liveCars(): LiveData<List<CarsResponse>> {
        return mutableLiveDataOfCars
    }

    fun getCars() {
        postgresql.getAllCars().enqueue(object : Callback<List<CarsResponse>> {


            override fun onResponse(
                call: Call<List<CarsResponse>>,
                response: Response<List<CarsResponse>>
            ) {
                if (response.isSuccessful) {
                    Log.i("[API]", "reponse : " + response.body().toString())
                    mutableLiveDataOfCars.value = response.body()
                }
            }

            override fun onFailure(call: Call<List<CarsResponse>>, t: Throwable) {
                Log.i("[API]", "Message : " + t.message.toString())
            }

        }
        )
    }

}