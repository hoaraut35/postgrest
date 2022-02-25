package com.hoarauthomas.postgrest.models

import com.google.gson.annotations.SerializedName

data class CarsResponse2(

	@field:SerializedName("CarsResponse2")
	val carsResponse2: List<CarsResponse2Item?>? = null
)

data class CarsResponse2Item(

	@field:SerializedName("ident")
	val ident: Int? = null,

	@field:SerializedName("maker")
	val maker: String? = null
)
