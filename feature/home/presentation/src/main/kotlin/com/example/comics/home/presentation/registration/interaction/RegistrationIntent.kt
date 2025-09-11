package com.example.comics.home.presentation.registration.interaction

internal sealed interface RegistrationIntent {
    data class OnNameChanged(val name: String): RegistrationIntent
    data class OnDocumentChanged(val document: String): RegistrationIntent
    object OnRegisterClicked: RegistrationIntent
}