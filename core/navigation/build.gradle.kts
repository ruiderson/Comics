import extensions.moduleImplementation
import extensions.setNamespace
import modules.FeatureModules
import setup.composeImplementation

plugins {
    alias(libs.plugins.project.module)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kotlinSerialization)
}

android {
    setNamespace("navigation")

    buildFeatures {
        compose = true
    }
}

dependencies {
    composeImplementation(project)
    implementation(libs.androidx.navigation.compose)

    moduleImplementation(FeatureModules.Home.Presentation)
}
