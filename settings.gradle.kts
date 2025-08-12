pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "Comics"
include(":app")
includeBuild("buildComposite")

include(
    ":core:data",
    ":core:designsystem",
    ":core:domain",
    ":core:navigation",
    ":core:presentation",
)

include(
    ":feature:home:data",
    ":feature:home:domain",
    ":feature:home:presentation",
)
