package com.example.comics.data.themoviedb

import com.example.comics.data.BuildConfig
import com.example.comics.data.base.HttpClientProvider
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

internal class TheMovieDbApiImpl(
    httpClientProvider: HttpClientProvider
) : TheMovieDbApi {
    private val httpClient: HttpClient = httpClientProvider.provide(
        baseUrl = BuildConfig.COMICS_API_URL,
        bearerToken = BuildConfig.COMICS_API_KEY
    )

    override suspend fun getComics(page: Int, itemsPerPage: Int): TheMovieDbData {
        val response = httpClient.get("trending/movie/day").body<TheMovieDbResponseDto>()
        return TheMovieDbData(
            imageBaseUrl = "http://image.tmdb.org/t/p/w500/",
            response = response
        )
    }
}
