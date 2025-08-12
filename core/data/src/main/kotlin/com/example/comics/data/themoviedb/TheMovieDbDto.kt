package com.example.comics.data.themoviedb

import android.annotation.SuppressLint
import kotlinx.serialization.Serializable

data class TheMovieDbData(
    val imageBaseUrl: String,
    val response: TheMovieDbResponseDto
)

@SuppressLint("UnsafeOptInUsageError")
@Serializable
data class TheMovieDbResponseDto(
    val page: Int? = null,
    val results: List<TheMovieDbItemDto>? = null,
    val total_pages: Int? = null,
    val status_message: String? = null,
)

@SuppressLint("UnsafeOptInUsageError")
@Serializable
data class TheMovieDbItemDto(
    val id: Long,
    val title: String? = null,
    val overview: String? = null,
    val poster_path: String? = null,
)
