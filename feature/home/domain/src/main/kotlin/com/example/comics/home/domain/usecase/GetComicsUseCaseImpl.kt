package com.example.comics.home.domain.usecase

import com.example.comics.domain.models.Comic
import com.example.comics.domain.models.PaginationData
import com.example.comics.home.domain.repository.HomeRepository

internal class GetComicsUseCaseImpl(
    private val repository: HomeRepository
) : GetComicsUseCase {
    override suspend operator fun invoke(
        page: Int,
        itemsPerPage: Int
    ): Result<PaginationData<Comic>> = runCatching {
        repository.getComics(page, itemsPerPage)
    }
}
