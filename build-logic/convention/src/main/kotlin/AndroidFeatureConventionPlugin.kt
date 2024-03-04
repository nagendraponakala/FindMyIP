import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidFeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target){
            with(pluginManager){
                apply("photon.android.library")
                apply("photon.android.library.compose")
            }

            dependencies {
                add("implementation", project(":core:designsystem"))
            }
        }
    }
}