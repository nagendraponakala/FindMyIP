plugins {
    `kotlin-dsl`
}

group = "com.photon.buildlogic"

dependencies {
    compileOnly(libs.android.gradle.plugin){
        because("gradle plugin to build android applications")
    }
    compileOnly(libs.kotlin.android.plugin)
}

gradlePlugin{
    plugins {
        register("androidApplication"){
            id = "photon.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidApplicationCompose"){
            id = "photon.android.application.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }
        register("androidLibrary"){
            id = "photon.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("androidLibraryCompose"){
            id = "photon.android.library.compose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }
        register("androidFeature"){
            id = "photon.android.feature"
            implementationClass = "AndroidFeatureConventionPlugin"
        }
    }
}