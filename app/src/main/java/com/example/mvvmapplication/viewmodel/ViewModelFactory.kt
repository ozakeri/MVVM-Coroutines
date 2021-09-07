package com.example.mvvmapplication.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmapplication.network.ApiHelper
import com.example.mvvmapplication.network.MainRepository

class ViewModelFactory (val apiHelper: ApiHelper) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
            return UserViewModel(apiHelper) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}