package com.photon.core.network

import com.photon.core.network.model.IpResponse
import retrofit2.Response
import retrofit2.http.GET

internal interface PhotonApi {

    @GET("json")
    suspend fun findMyIp(): Response<IpResponse>
}