package com.example.mvvmapplication.network

import javax.inject.Inject

class ApiHelper @Inject constructor(private val apiService: ApiService) {
    suspend fun getUsers() = apiService.getUsers()
}