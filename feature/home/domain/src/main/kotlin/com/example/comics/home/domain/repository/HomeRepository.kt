package com.example.comics.home.domain.repository

import com.example.comics.domain.models.Comic
import com.example.comics.domain.models.PaginationData

interface HomeRepository {
    suspend fun getComics(page: Int, itemsPerPage: Int): PaginationData<Comic>
}