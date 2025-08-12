package com.example.comics.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class Comic(
    val id: Long,
    val title: String,
    val description: String?,
    val image: String?
)
