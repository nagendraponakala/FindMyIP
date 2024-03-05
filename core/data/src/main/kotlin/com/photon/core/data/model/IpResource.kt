package com.photon.core.data.model

import com.photon.core.model.IpData
import com.photon.core.network.model.IpResponse

fun IpResponse.toIpData(): IpData {
    return IpData(
        ip = this.ip,
        city = this.city,
        region = this.region,
        countryName = this.countryName,
        postal = this.postal,
        latitude = this.latitude,
        longitude = this.longitude,
    )
}