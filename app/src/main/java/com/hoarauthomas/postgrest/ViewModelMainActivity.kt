package com.hoarauthomas.postgrest

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.hoarauthomas.postgrest.models.CarsResponse
import com.hoarauthomas.postgrest.models.CarsResponseItem
import com.hoarauthomas.postgrest.repositories.PostgreRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ViewModelMainActivity @Inject constructor(private val postgreRepository: PostgreRepository) : ViewModel() {


    fun callAPI(){
        postgreRepository.getCars()
    }

    fun liveCars(): LiveData<List<CarsResponseItem>>{
        return postgreRepository.liveCars()
    }



}

