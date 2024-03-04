pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "FindMyIP"
include(":app")
include(":feature:findmyip")
include(":core:designsystem")
include(":core:data")
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
