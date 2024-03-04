package com.photon

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project

internal fun Project.configureCompose(
    commonExtension: CommonExtension<*, *, *, *, *>
){
    commonExtension.apply {
        composeOptions {
            kotlinCompilerExtensionVersion = "1.5.10"
        }

        buildFeatures {
            compose = true
        }
    }
}