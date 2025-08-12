import extensions.setNamespace
import setup.composeImplementation

plugins {
    alias(libs.plugins.project.module)
    alias(libs.plugins.compose.compiler)
}

android {
    setNamespace("presentation")

    buildFeatures {
        compose = true
    }
}

dependencies {
    composeImplementation(project)
    implementation(libs.androidx.navigation.compose)

    implementation(libs.coil.network)
    implementation(libs.coil.compose)
}
