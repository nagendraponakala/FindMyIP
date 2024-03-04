plugins {
    alias(libs.plugins.photon.android.library)
    alias(libs.plugins.photon.android.hilt)
    id("kotlinx-serialization")
}

android {
    namespace = "com.photon.core.network"
}

dependencies {
    api(libs.retrofit.core)
    implementation(libs.kotlinx.serialization)
    implementation(libs.retrofit.kotlinx.serialization)
    implementation(libs.okhttp.logging)
}