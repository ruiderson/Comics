package settings

import org.gradle.api.JavaVersion
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

object ProjectSettings {
    const val namespace = "com.example.comics"
    const val id = namespace
    const val versionCode = 1
    const val versionName = "1.0"
    const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    val javaVersion = JavaVersion.VERSION_17
    val jvmTarget = JvmTarget.JVM_11
}
