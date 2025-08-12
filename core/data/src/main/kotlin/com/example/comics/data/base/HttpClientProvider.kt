package com.example.comics.data.base

import io.ktor.client.HttpClient

internal interface HttpClientProvider {
    fun provide(baseUrl: String, bearerToken: String? = null): HttpClient
}
