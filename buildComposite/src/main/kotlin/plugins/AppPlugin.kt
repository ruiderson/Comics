package plugins

import extensions.alias
import extensions.android
import extensions.kotlin
import extensions.libs
import extensions.plugins
import org.gradle.api.Plugin
import org.gradle.api.Project
import settings.ProjectSettings

class AppPlugin : Plugin<Project> {
    override fun apply(project: Project) = with(project) {
        plugins {
            alias(libs.plugins.androidApplication)
            alias(libs.plugins.kotlinAndroid)
            alias(libs.plugins.compose.compiler)
        }

        kotlin {
            jvmToolchain(ProjectSettings.jvmToolchain)
        }

        android {
            namespace = ProjectSettings.namespace
            compileSdk = libs.versions.android.compileSdk.get().toInt()

            defaultConfig {
                minSdk = libs.versions.android.minSdk.get().toInt()
                targetSdk = libs.versions.android.targetSdk.get().toInt()
                testInstrumentationRunner = ProjectSettings.testInstrumentationRunner

                javaCompileOptions {
                    annotationProcessorOptions {
                        arguments += mapOf(
                            "room.schemaLocation" to "$projectDir/schemas",
                            "room.incremental" to "true"
                        )
                    }
                }
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
