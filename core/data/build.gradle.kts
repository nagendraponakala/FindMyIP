import org.gradle.internal.impldep.com.google.api.services.storage.Storage.Projects

plugins {
    alias(libs.plugins.photon.android.library)
    alias(libs.plugins.photon.android.hilt)
}

android {
    namespace = "com.photon.core.data"
}

dependencies {
    implementation(projects.core.network)
    implementation(projects.core.model)
    implementation(projects.core.common)
}