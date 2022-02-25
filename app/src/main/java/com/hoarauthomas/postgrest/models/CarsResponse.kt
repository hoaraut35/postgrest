package com.hoarauthomas.postgrest.models

import com.google.gson.annotations.SerializedName

data class CarsResponse(

	@field:SerializedName("CarsResponse")
	val carsResponse: List<CarsResponseItem?>? = null
)

data class CarsResponseItem(

	@field:SerializedName("ident")
	val ident: Int? = null,

	@field:SerializedName("maker")
	val maker: String? = null
)
