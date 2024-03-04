@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.photon.android.feature)
}

android {
    namespace = "com.photon.feature.findmyip"

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }
}

dependencies {
}