import extensions.moduleImplementation
import extensions.setNamespace
import modules.FeatureModules

plugins {
    alias(libs.plugins.project.presentation)
    alias(libs.plugins.kotlinSerialization)
}

android {
    setNamespace("home.presentation")
}

dependencies {
    moduleImplementation(FeatureModules.Home.Domain)

    implementation(libs.compose.paging)
}
