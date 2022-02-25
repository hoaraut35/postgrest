package com.hoarauthomas.postgrest

import androidx.lifecycle.ViewModel
import com.hoarauthomas.postgrest.repositories.PostgreRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ViewModelMainActivity @Inject constructor(private val postgreRepository: PostgreRepository) : ViewModel() {





}

