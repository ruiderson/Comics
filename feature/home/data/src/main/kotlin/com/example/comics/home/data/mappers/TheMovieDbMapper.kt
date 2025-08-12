package com.example.comics.home.data.mappers

import com.example.comics.data.themoviedb.TheMovieDbItemDto
import com.example.comics.domain.models.Comic

fun TheMovieDbItemDto.toComic(
    imageBaseUrl: String
) = Comic(
    id = this.id,
    title = this.title ?: "",
    description = this.overview ?: "",
    image = this.poster_path.let { "${imageBaseUrl}.${it}" }
)
