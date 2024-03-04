package com.photon.core.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.photon.core.network.model.IpResponse
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject

private const val BASE_URL = "https://ipapi.co"

class PhotonNetwork @Inject constructor(
    networkJson: Json,
    client: OkHttpClient
) : PhotonNetworkDataSource {
    private val networkApi = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(
            networkJson.asConverterFactory(
                contentType = "application/json".toMediaType()
            )
        )
        .build()
        .create(PhotonApi::class.java)

    override suspend fun findMyIp(): Response<IpResponse> {
        return networkApi.findMyIp()
    }

}