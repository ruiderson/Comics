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
        }

        kotlin {
            compilerOptions.jvmTarget.set(ProjectSettings.jvmTarget)
        }

        android {
            namespace = ProjectSettings.namespace
            compileSdk = libs.versions.android.compileSdk.get().toInt()

            defaultConfig {
                applicationId = ProjectSettings.id
                minSdk = libs.versions.android.minSdk.get().toInt()
                targetSdk = libs.versions.android.targetSdk.get().toInt()
                versionCode = ProjectSettings.versionCode
                versionName = ProjectSettings.versionName

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
