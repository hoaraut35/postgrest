package com.hoarauthomas.postgrest.repositories

import com.hoarauthomas.postgrest.api.Postgrestapi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PostgreRepository @Inject constructor(private val postgresql: Postgrestapi) {
}