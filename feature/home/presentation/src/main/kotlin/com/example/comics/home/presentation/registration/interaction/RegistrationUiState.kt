package com.example.comics.home.presentation.registration.interaction

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
internal sealed interface RegistrationUiState : Parcelable {
    @Serializable object Active : RegistrationUiState
    @Serializable object Loading : RegistrationUiState
    @Serializable data class Error(val message: String) : RegistrationUiState
}
