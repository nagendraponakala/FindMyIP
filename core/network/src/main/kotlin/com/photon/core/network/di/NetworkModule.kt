package com.photon.core.network.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.photon.core.network.PhotonNetwork
import com.photon.core.network.PhotonNetworkDataSource
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideNetworkJson(): Json {
        return Json {
            ignoreUnknownKeys = true
            isLenient = true
        }
    }

//    @Provides
//    @Singleton
//    fun provideKotlinSerialization(): Converter.Factory {
//        val contentType = "application/json".toMediaType()
//        val json = Json {
//            ignoreUnknownKeys = true
//            isLenient = true
//        }
//        return json.asConverterFactory(contentType)
//    }

    @Provides
    @Singleton
    fun providesOkHttpClient(): OkHttpClient {
        return OkHttpClient
            .Builder()
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    setLevel(HttpLoggingInterceptor.Level.BODY)
                }
            )
            .build()
    }
}

@Module
@InstallIn(SingletonComponent::class)
internal interface FlavoredNetworkModule {

    @Binds
    fun binds(impl: PhotonNetwork): PhotonNetworkDataSource
}