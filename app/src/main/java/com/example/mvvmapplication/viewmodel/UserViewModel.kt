package com.example.mvvmapplication.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.mvvmapplication.network.ApiHelper
import com.example.mvvmapplication.utils.Resourse
import kotlinx.coroutines.Dispatchers

class UserViewModel(val apiHelper: ApiHelper) : ViewModel() {

    fun fetchUser() = liveData(Dispatchers.IO) {
        emit(Resourse.loading(data = null))
        try {
            emit(Resourse.success(data = apiHelper.getUsers()))
        } catch (exception: Exception) {
            emit(Resourse.error(data = null, message = exception.message))
        }
    }
}