package com.photon.core.data

import com.photon.core.common.Result
import com.photon.core.model.IpData
import kotlinx.coroutines.flow.Flow

interface FindMyIpRepository {
    fun findMyIp() : Flow<Result<IpData>>
}