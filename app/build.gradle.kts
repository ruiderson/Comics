import extensions.implementation
import extensions.moduleImplementation
import modules.CoreModules
import modules.FeatureModules
import settings.ProjectSettings
import setup.composeImplementation

plugins {
    alias(libs.plugins.project.app)
}

android {
    defaultConfig {
        applicationId = ProjectSettings.id
        versionCode = ProjectSettings.versionCode
        versionName = ProjectSettings.versionName
    }
}

dependencies {
    moduleImplementation(
        CoreModules.Data,
        CoreModules.DesignSystem,
        CoreModules.Domain,
        CoreModules.Navigation,
        CoreModules.Presentation
    )

    moduleImplementation(
        FeatureModules.Home.Data,
                FeatureModules.Home.Domain,
                FeatureModules.Home.Presentation,
    )

    implementation(libs.androidx.activity.compose)
    composeImplementation(project)

    implementation(libs.koin.core)
    implementation(libs.koin.android)
    implementation(libs.koin.compose.core)
}