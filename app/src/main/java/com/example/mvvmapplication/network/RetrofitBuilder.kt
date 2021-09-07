package com.example.mvvmapplication.network

import com.example.mvvmapplication.constant.Constant
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(Constant.BaseUrl)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    val apiService: ApiService = getRetrofit().create(ApiService::class.java)
}