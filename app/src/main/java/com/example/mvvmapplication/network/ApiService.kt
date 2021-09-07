package com.example.mvvmapplication.network

import com.example.mvvmapplication.model.User
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    suspend fun getUsers(): List<User>
}