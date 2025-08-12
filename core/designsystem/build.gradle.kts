import extensions.setNamespace
import setup.composeImplementation

plugins {
    alias(libs.plugins.project.module)
    alias(libs.plugins.compose.compiler)
}

android {
    setNamespace("design.system")

    buildFeatures {
        compose = true
    }
}

dependencies {
    composeImplementation(project)
}
