//import com.photon.libs

plugins {
    alias(libs.plugins.photon.android.application)
    alias(libs.plugins.photon.android.application.compose)
    alias(libs.plugins.photon.android.hilt)
}

android {
    namespace = "com.photon.findmyip"

    defaultConfig {
        applicationId = "com.photon.findmyip"
        multiDexEnabled = true
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(libs.androidx.multidex)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.navigation.compose)
    implementation(projects.core.designsystem)
    implementation(projects.feature.findmyip)
}