package plugins

import extensions.alias
import extensions.androidLib
import extensions.implementation
import extensions.kotlin
import extensions.libs
import extensions.moduleImplementation
import extensions.plugins
import modules.CoreModules
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import settings.ProjectSettings

class PresentationPlugin : Plugin<Project> {
    override fun apply(project: Project) = with(project) {
        plugins {
            alias(libs.plugins.androidLibrary)
            alias(libs.plugins.kotlinAndroid)
            alias(libs.plugins.compose.compiler)
        }

        dependencies {
            moduleImplementation(
                CoreModules.Domain,
                CoreModules.DesignSystem,
                CoreModules.Presentation
            )

            implementation(libs.koin.core)
            implementation(libs.koin.android)
            implementation(libs.koin.compose.core)
            implementation(libs.koin.compose.viewmodel)
        }

        kotlin {
            jvmToolchain(ProjectSettings.jvmToolchain)
        }

        androidLib {
            compileSdk = libs.versions.android.compileSdk.get().toInt()

            defaultConfig {
                minSdk = libs.versions.android.minSdk.get().toInt()
            }

            buildFeatures {
                compose = true
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
