package com.example.mvvmapplication.utils

data class Resourse<T>(val status: Status?, val data: T?, val message: String?) {

    companion object{
        fun <T> success(data: T?): Resourse<T> {
            return Resourse(Status.SUCCESS, data, null)
        }

        fun <T> error(data: T?, message: String?): Resourse<T> {
            return Resourse(Status.ERROR, data, message)
        }

        fun <T> loading(data: T?): Resourse<T> {
            return Resourse(Status.LOADING, data, null)
        }
    }
}