package com.spacemooncake.materialdesign.model

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RepositoryImpl : Repository{

    private val baseURL = "GET https://api.nasa.gov/"

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
            .build()
    }
    fun getPictureOfTheDayApi() : PictureOfTheDayAPI{
        return(retrofit.create(PictureOfTheDayAPI::class.java))
    }

}