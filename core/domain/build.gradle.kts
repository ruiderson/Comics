plugins {
    alias(libs.plugins.kotlinLib)
    alias(libs.plugins.kotlinSerialization)
}

dependencies {
    implementation(libs.kotlinx.serialization.core)
    implementation(libs.kotlinx.serialization.json)
}
