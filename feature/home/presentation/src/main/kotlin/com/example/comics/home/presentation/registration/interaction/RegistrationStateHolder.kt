package com.example.comics.home.presentation.registration.interaction

import androidx.compose.runtime.Immutable

@Immutable
internal data class RegistrationStateHolder(
    val name: String = "",
    val document: String = ""
)
