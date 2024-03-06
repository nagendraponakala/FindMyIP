package com.photon.core.data

import com.photon.core.common.Result
import com.photon.core.data.model.toIpData
import com.photon.core.model.IpData
import com.photon.core.network.AppDispatchers
import com.photon.core.network.Dispatchers
import com.photon.core.network.PhotonNetworkDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

internal class FindMyIpRepositoryImpl @Inject constructor(
    @Dispatchers(AppDispatchers.IO) private val ioDispatcher: CoroutineDispatcher,
    private val network: PhotonNetworkDataSource,
) : FindMyIpRepository {
    override fun findMyIp() : Flow<Result<IpData>> = flow {
        try {
            val response = network.findMyIp()
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) {
                    emit(Result.Success(data = body.toIpData()))
                } else {
                    emit(Result.Error(message = "No data received from server"))
                }
            } else {
                emit(Result.Error(message = response.errorBody()?.string()))
            }
        } catch (ex: Exception) {
            emit(Result.Error(message = ex.message ?: "An unexpected error occurred"))
        }
    }.flowOn(ioDispatcher)
}