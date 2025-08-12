package com.example.comics.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class PaginationData<T>(
    val items: List<T>,
    val currentPage: Int,
    val itemsPerPage: Int,
    val endReached: Boolean
)
