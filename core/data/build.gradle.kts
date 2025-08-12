import extensions.setNamespace

plugins {
    alias(libs.plugins.project.module)
    alias(libs.plugins.kotlinSerialization)
}

android {
    setNamespace("data")

    android.buildFeatures.buildConfig = true
    defaultConfig {
        buildConfigField(
            "String",
            "COMICS_API_URL",
            "\"https://api.themoviedb.org/3/\""
        )

        buildConfigField(
            "String",
            "COMICS_API_KEY",
            "\"eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJmMjJjNmNjZTJmMThjZGQ3YmEwYmUyYjlmYTJiOGU3MyIsIm5iZiI6MTc0MzE3OTQyMi4zODgsInN1YiI6IjY3ZTZjZTllZjg0Njc5NGU5OTEwZjY0MSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.i-FWN8afMCXSY6Skjs1K_5pf_qyX8yaU0ehq4ve8SqM\""
        )
    }
}

dependencies {
    implementation(libs.ktor.client.core)
    implementation(libs.ktor.client.contentNegotiation)
    implementation(libs.ktor.client.serialization)
    implementation(libs.ktor.okhttp)
    implementation(libs.ktor.auth)
}