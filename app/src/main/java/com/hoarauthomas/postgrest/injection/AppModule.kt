package com.hoarauthomas.postgrest.injection

import com.hoarauthomas.postgrest.api.Postgrestapi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    //provide retrofit
    @Provides
    @Singleton
    fun provideRetrofit(): Postgrestapi = Retrofit.Builder()
        .baseUrl("localhost:3000/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(Postgrestapi::class.java)

    //provide scope
    @ApplicationScope
    @Provides
    @Singleton
    fun provideApplicationScope() = CoroutineScope(SupervisorJob())

}

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class ApplicationScope