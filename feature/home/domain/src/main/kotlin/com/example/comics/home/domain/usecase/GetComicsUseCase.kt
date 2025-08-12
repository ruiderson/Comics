package com.example.comics.home.domain.usecase

import com.example.comics.domain.models.Comic
import com.example.comics.domain.models.PaginationData

interface GetComicsUseCase {
    suspend operator fun invoke(page: Int, itemsPerPage: Int): Result<PaginationData<Comic>>
}
