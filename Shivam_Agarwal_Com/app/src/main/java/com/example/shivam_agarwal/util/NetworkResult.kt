package com.example.shivam_agarwal.util


sealed class NetworkResult<T> (
    val data: T? = null,
    val errorMessage: String? = null
) {
    class Loading<T> : NetworkResult<T>()
    class Success<T>(data: T) : NetworkResult<T>(data)
    class Error<T>(errorMessage: String, data: T? = null) : NetworkResult<T>(data, errorMessage)

}

