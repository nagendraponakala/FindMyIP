package com.photon

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

internal fun Project.configureKotlinAndroid(
    commonExtension: CommonExtension<*, *, *, *, *>
){
    commonExtension.compileSdk = libs.findVersion("compile-sdk").get().toString().toInt()

    commonExtension.defaultConfig {
        minSdk = libs.findVersion("min-sdk").get().toString().toInt()
    }

    configureKotlin()
}

internal fun Project.configureKotlin(){
    tasks.withType<KotlinCompile>().configureEach {
        kotlinOptions {
            jvmTarget = JavaVersion.VERSION_1_8.toString()
        }
    }
}