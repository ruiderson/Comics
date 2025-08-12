package extensions

import org.gradle.api.artifacts.MinimalExternalModuleDependency
import org.gradle.api.provider.Provider
import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.kotlin.dsl.project

fun DependencyHandlerScope.moduleImplementation(vararg modules: String) {
    modules.forEach {
        add("api", project(it))
    }
}

fun DependencyHandlerScope.implementation(vararg modules: Provider<MinimalExternalModuleDependency>) {
    modules.forEach {
        add("api", it)
    }
}