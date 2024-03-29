@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.photon.android.library)
    alias(libs.plugins.photon.android.library.compose)
}

android {
    namespace = "com.photon.core.designsystem"
}

dependencies {
    api(libs.androidx.compose.foundation)
    api(libs.androidx.compose.foundation.layout)
    api(libs.androidx.compose.material.iconsExtended)
    api(libs.androidx.compose.material3)
    api(libs.androidx.compose.ui.tooling.preview)
    api(libs.androidx.compose.ui.util)
    api(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.core)
    debugApi(libs.androidx.compose.ui.tooling)
}