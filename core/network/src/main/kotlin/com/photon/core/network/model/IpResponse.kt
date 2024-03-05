package com.photon.core.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class IpResponse(
    val ip: String, // ex: "124.123.178.88"
    val city: String,   // ex: "Hyderabad"
    val region: String, // ex: "Telangana"
    @SerialName("country_name")
    val countryName: String, // ex: "India"
    val postal: String, // ex: "postal": "500002"
    val latitude: Double, // "latitude": 17.3724
    val longitude: Double, // ex: 78.4378
)