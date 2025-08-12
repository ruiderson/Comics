package setup

import extensions.implementation
import extensions.libs
import org.gradle.api.Project
import org.gradle.kotlin.dsl.DependencyHandlerScope

fun DependencyHandlerScope.composeImplementation(project: Project) {
    val libs = project.libs

    implementation(libs.compose.material3)
}