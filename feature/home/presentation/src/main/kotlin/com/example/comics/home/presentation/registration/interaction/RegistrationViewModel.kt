package com.example.comics.home.presentation.registration.interaction

import androidx.lifecycle.SavedStateHandle
import com.example.comics.presentation.interaction.ComposeViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

class RegistrationViewModel(
    savedStateHandle: SavedStateHandle
) : ComposeViewModel(savedStateHandle) {

    private val _state by savableStateFlowOf(RegistrationStateHolder())
    internal val state = _state.asStateFlow()

    private val _effect = MutableSharedFlow<RegistrationEffect>()
    internal val effect = _effect.asSharedFlow()

    internal fun onIntent(intent: RegistrationIntent) = when(intent) {
        is RegistrationIntent.OnNameChanged -> onNameChanged(intent.name)
        is RegistrationIntent.OnDocumentChanged -> onDocumentChanged(intent.document)
        is RegistrationIntent.OnRegisterClicked -> onRegisterClicked()
    }

    private fun onNameChanged(name: String) = _state.update {
        it.copy(
            name = name
        )
    }

    private fun onDocumentChanged(document: String) = _state.update {
        it.copy(
            document = document
        )
    }

    private fun onRegisterClicked() = _state.update {
        it.copy(
            uiState = RegistrationUiState.Loading
        )
    }
}
