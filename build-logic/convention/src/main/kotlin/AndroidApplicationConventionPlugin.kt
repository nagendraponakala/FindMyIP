import com.android.build.api.dsl.ApplicationExtension
import com.photon.configureCompose
import com.photon.configureKotlinAndroid
import com.photon.libs
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target){
            with(pluginManager){
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
            }

            extensions.configure<ApplicationExtension> {
                configureKotlinAndroid(this)
                defaultConfig {
                    targetSdk = libs.findVersion("target-sdk").get().toString().toInt()
                    versionCode = libs.findVersion("version-code").get().toString().toInt()
                    versionName = libs.findVersion("version-name").get().toString()
                }

                compileOptions {
                    sourceCompatibility = JavaVersion.VERSION_1_8
                    targetCompatibility = JavaVersion.VERSION_1_8
                }
            }
        }
    }
}