package com.photon.core.network

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Dispatchers(val dispatcher: AppDispatchers)

enum class AppDispatchers {
    IO,
    Default
}