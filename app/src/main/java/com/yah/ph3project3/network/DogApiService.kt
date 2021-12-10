package com.yah.ph3project3.network

import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://dog.ceo/api/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface DogApiService {
    @GET("breeds/image/random")
    suspend fun getRandomPhoto(): DogPhoto
}

/**
 * 1. Object allows access outside of class
 * 2. Accessible variables live inside object
 * 3. [retrofitService] references the [DogApiService] interface
 * 4. You then have access to the methods inside the interface
 */
object DogPhotoApi {
    val retrofitService: DogApiService by lazy {
        retrofit.create((DogApiService::class.java))
    }
}
