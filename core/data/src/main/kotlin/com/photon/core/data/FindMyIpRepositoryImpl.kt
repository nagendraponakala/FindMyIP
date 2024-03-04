package com.photon.core.data

import com.photon.core.data.model.toIpData
import com.photon.core.model.IpData
import com.photon.core.network.PhotonNetworkDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import com.photon.core.common.Result
import javax.inject.Inject

internal class FindMyIpRepositoryImpl @Inject constructor(
    private val network: PhotonNetworkDataSource,
) : FindMyIpRepository {
    override fun findMyIp() : Flow<Result<IpData>> {
        return flow<Result<IpData>> {
            try {
                val response = network.findMyIp()
                if (response.isSuccessful) {
                    val body = response.body()
                    if (body != null) {
                        emit(
                            Result.Success(
                                data = response.body()!!.toIpData()
                            )
                        )
                    } else {
                        emit(
                            Result.Error(
                                message = "Looks like the server didn't send any information. Please try again later"
                            )
                        )
                    }
                } else {
                    emit(
                        Result.Error(
                            message = response.errorBody()?.string()
                        )
                    )
                }
            } catch (ex: Exception) {
                emit(
                    Result.Error(
                        message = ex.message
                    )
                )
            }
        }.flowOn(Dispatchers.IO)
    }
}