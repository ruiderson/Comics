import extensions.moduleImplementation
import extensions.setNamespace
import modules.FeatureModules

plugins {
    alias(libs.plugins.project.data)
}

android {
    setNamespace("home.data")
}

dependencies {
    moduleImplementation(FeatureModules.Home.Domain)
}
