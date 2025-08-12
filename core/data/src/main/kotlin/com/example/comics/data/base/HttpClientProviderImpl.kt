package com.example.comics.data.base

import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.providers.BearerTokens
import io.ktor.client.plugins.auth.providers.bearer
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.http.takeFrom
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

internal class HttpClientProviderImpl : HttpClientProvider {
    override fun provide(
        baseUrl: String,
        bearerToken: String?
    ): HttpClient {
        return HttpClient(OkHttp.create()) {
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                })
            }

            bearerToken?.let {
                install(Auth) {
                    bearer {
                        loadTokens {
                            BearerTokens(it, it)
                        }
                    }
                }
            }

            defaultRequest {
                url.takeFrom(baseUrl)
            }
        }
    }
}
