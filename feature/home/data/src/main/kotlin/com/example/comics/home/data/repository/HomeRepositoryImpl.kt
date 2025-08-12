package com.example.comics.home.data.repository

import com.example.comics.domain.models.Comic
import com.example.comics.domain.models.PaginationData
import com.example.comics.home.data.datasource.ComicsRemoteDataSource
import com.example.comics.home.domain.repository.HomeRepository

internal class HomeRepositoryImpl(
    private val remoteDataSource: ComicsRemoteDataSource
) : HomeRepository {
    override suspend fun getComics(page: Int, itemsPerPage: Int): PaginationData<Comic> {
        return remoteDataSource.getComics(page, itemsPerPage)
    }
}
