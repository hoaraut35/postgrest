package com.hoarauthomas.postgrest.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hoarauthomas.postgrest.api.Postgrestapi
import com.hoarauthomas.postgrest.models.CarsResponse
import com.hoarauthomas.postgrest.models.CarsResponseItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class PostgreRepository @Inject constructor(private val postgresql: Postgrestapi) {

    private var mutableLiveDataOfCars = MutableLiveData<List<CarsResponseItem>>()

    fun liveCars(): LiveData<List<CarsResponseItem>> {
        return mutableLiveDataOfCars
    }

    fun getCars() {
        postgresql.getAllCars().enqueue(object : Callback<List<CarsResponseItem>> {

            override fun onResponse(
                call: Call<List<CarsResponseItem>>,
                response: Response<List<CarsResponseItem>>
            ) {
                if (response.isSuccessful) {

                    mutableLiveDataOfCars.value = response.body()
                    Log.i("[API]", "reponse : " + response.body())
                }
            }

            override fun onFailure(call: Call<List<CarsResponseItem>>, t: Throwable) {
                Log.i("[API]", "Message : " + t.message.toString())
            }


        }
        )
    }

}