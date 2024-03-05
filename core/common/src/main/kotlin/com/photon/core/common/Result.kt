package com.photon.core.common

sealed interface Result<out T> {
    data class Success<T>(val data: T?): Result<T>
    data class Error(val message: String?): Result<Nothing>
}