package com.photon.core.network

import com.photon.core.network.model.IpResponse
import retrofit2.Response

interface PhotonNetworkDataSource {
    suspend fun findMyIp() : Response<IpResponse>
}