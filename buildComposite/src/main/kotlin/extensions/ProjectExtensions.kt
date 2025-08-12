package extensions

import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.api.Action
import org.gradle.api.Project
import org.gradle.api.plugins.PluginContainer
import org.gradle.api.provider.Provider
import org.gradle.kotlin.dsl.the
import org.gradle.plugin.use.PluginDependency
import org.jetbrains.kotlin.gradle.dsl.KotlinAndroidProjectExtension
import settings.ProjectSettings

internal fun Project.plugins(action: Action<PluginContainer>) {
    project.plugins.apply {
        action.execute(this)
    }
}

internal fun Project.kotlin(action: Action<KotlinAndroidProjectExtension>) {
    (project.extensions.getByName("kotlin") as? KotlinAndroidProjectExtension)?.let {
        action.execute(it)
    }
}

internal fun Project.android(action: Action<BaseAppModuleExtension>) {
    (project.extensions.getByName("android") as? BaseAppModuleExtension)?.let {
        action.execute(it)
    }
}

internal fun Project.androidLib(action: Action<LibraryExtension>) {
    (project.extensions.getByName("android") as? LibraryExtension)?.let {
        action.execute(it)
    }
}

fun LibraryExtension.setNamespace(value: String) {
    namespace = "${ProjectSettings.namespace}.${value}"
}

fun PluginContainer.kotlin(plugin: Provider<PluginDependency>) {
    with(plugin.get()) {
        apply("org.jetbrains.kotlin.${pluginId}")
    }
}

fun PluginContainer.id(plugin: Provider<PluginDependency>) {
    apply(plugin.get().pluginId)
}

fun PluginContainer.alias(plugin: Provider<PluginDependency>) {
    apply(plugin.get().pluginId)
}

fun PluginContainer.apply(plugin: Provider<PluginDependency>) {
    apply(plugin.get().pluginId)
}

internal val Project.libs: LibrariesForLibs
    get() = the()