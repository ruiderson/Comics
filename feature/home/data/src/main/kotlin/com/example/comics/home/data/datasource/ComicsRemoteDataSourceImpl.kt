package com.example.comics.home.data.datasource

import com.example.comics.data.themoviedb.TheMovieDbApi
import com.example.comics.domain.models.Comic
import com.example.comics.domain.models.PaginationData
import com.example.comics.home.data.mappers.toComic

internal class ComicsRemoteDataSourceImpl(
    private val api: TheMovieDbApi
) : ComicsRemoteDataSource {
    override suspend fun getComics(
        page: Int,
        itemsPerPage: Int
    ): PaginationData<Comic> {
        val data = api.getComics(page, itemsPerPage)

        val items = data.response.results?.let {
            it.map {
                it.toComic(
                    imageBaseUrl = data.imageBaseUrl
                )
            }
        } ?: throw Exception(data.response.status_message)

        return PaginationData(
            items = items,
            currentPage = data.response.page ?: page,
            itemsPerPage = itemsPerPage,
            endReached = items.isEmpty()
        )
    }
}
