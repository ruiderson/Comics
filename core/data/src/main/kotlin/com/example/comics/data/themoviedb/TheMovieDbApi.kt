package com.example.comics.data.themoviedb

interface TheMovieDbApi {
    suspend fun getComics(page: Int, itemsPerPage: Int): TheMovieDbData
}
