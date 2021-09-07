package com.example.mvvmapplication.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.mvvmapplication.network.ApiHelper
import com.example.mvvmapplication.utils.Resourse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(val apiHelper: ApiHelper) : ViewModel() {

    fun fetchUser() = liveData(Dispatchers.IO) {
        emit(Resourse.loading(data = null))
        try {
            emit(Resourse.success(data = apiHelper.getUsers()))
        } catch (exception: Exception) {
            emit(Resourse.error(data = null, message = exception.message))
        }
    }
}