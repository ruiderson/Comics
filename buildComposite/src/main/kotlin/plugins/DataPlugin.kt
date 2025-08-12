package plugins

import extensions.alias
import extensions.androidLib
import extensions.kotlin
import extensions.libs
import extensions.moduleImplementation
import extensions.plugins
import modules.CoreModules
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import settings.ProjectSettings
import kotlin.text.toInt

class DataPlugin : Plugin<Project> {
    override fun apply(project: Project) = with(project) {
        plugins {
            alias(libs.plugins.androidLibrary)
            alias(libs.plugins.kotlinAndroid)
        }

        dependencies {
            moduleImplementation(
                CoreModules.Data,
                CoreModules.Domain
            )
        }

        kotlin {
            jvmToolchain(ProjectSettings.jvmToolchain)
        }

        androidLib {
            compileSdk = libs.versions.android.compileSdk.get().toInt()

            defaultConfig {
                minSdk = libs.versions.android.minSdk.get().toInt()
            }

            buildTypes {
                getByName("release") {
                    isMinifyEnabled = false
                    proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
                }
            }

            compileOptions {
                sourceCompatibility = ProjectSettings.javaVersion
                targetCompatibility = ProjectSettings.javaVersion
            }
        }
    }
}
