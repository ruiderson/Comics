package com.example.comics.home.presentation.registration.interaction

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
internal data class RegistrationStateHolder(
    val uiState: RegistrationUiState = RegistrationUiState.Active,
    val name: String = "",
    val document: String = ""
) : Parcelable
