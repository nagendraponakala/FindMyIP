package com.photon.core.model


data class IpData(
    val ip: String, // ex: "124.123.178.88"
    val city: String,   // ex: "Hyderabad"
    val region: String, // ex: "Telangana"
    val countryName: String, // ex: "India"
    val postal: String, // ex: "postal": "500002"
    val latitude: Double, // "latitude": 17.3724
    val longitude: Double, // ex: 78.4378
)