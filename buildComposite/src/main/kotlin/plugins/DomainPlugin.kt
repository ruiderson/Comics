package plugins

import extensions.alias
import extensions.implementation
import extensions.libs
import extensions.moduleImplementation
import extensions.plugins
import modules.CoreModules
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class DomainPlugin : Plugin<Project> {
    override fun apply(project: Project) = with(project) {
        plugins {
            alias(libs.plugins.kotlinLib)
        }


        dependencies {
            moduleImplementation(CoreModules.Domain)
            implementation(libs.kotlinx.serialization.core)
            implementation(libs.kotlinx.serialization.json)
            implementation(libs.koin.core)
        }
    }
}
