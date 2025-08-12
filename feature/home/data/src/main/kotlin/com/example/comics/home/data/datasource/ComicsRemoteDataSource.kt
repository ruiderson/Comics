package com.example.comics.home.data.datasource

import com.example.comics.domain.models.Comic
import com.example.comics.domain.models.PaginationData

internal interface ComicsRemoteDataSource {
    suspend fun getComics(page: Int, itemsPerPage: Int): PaginationData<Comic>
}
