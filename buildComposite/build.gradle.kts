plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
}

gradlePlugin {
    plugins {
        fun registerPlugin(plugin: Provider<PluginDependency>,) {
            val name = plugin.get().pluginId
            register(name) {
                id = name
                implementationClass = "plugins.${name}"
            }
        }

        registerPlugin(libs.plugins.project.app)
        registerPlugin(libs.plugins.project.data)
        registerPlugin(libs.plugins.project.domain)
        registerPlugin(libs.plugins.project.module)
        registerPlugin(libs.plugins.project.presentation)
    }
}

repositories {
    google()
    mavenCentral()
}

dependencies {
    implementation(libs.androidTools)
    implementation(libs.kotlinGradle)

    compileOnly(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
}
