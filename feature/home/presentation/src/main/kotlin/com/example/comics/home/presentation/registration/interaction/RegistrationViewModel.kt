package com.example.comics.home.presentation.registration.interaction

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class RegistrationViewModel : ViewModel() {

    private val _state = MutableStateFlow<RegistrationState>(
        RegistrationState.Active(RegistrationStateHolder())
    )
    internal val state = _state.asStateFlow()

    private val _effect = MutableSharedFlow<RegistrationEffect>()
    internal val effect = _effect.asSharedFlow()

    internal fun onIntent(intent: RegistrationIntent) = when(intent) {
        is RegistrationIntent.OnNameChanged -> onNameChanged(intent.name)
        is RegistrationIntent.OnDocumentChanged -> onDocumentChanged(intent.document)
        is RegistrationIntent.OnRegisterClicked -> onRegisterClicked()
    }

    private fun onNameChanged(name: String) {
        _state.update {
            RegistrationState.Active(
                stateHolder = state.value.stateHolder.copy(
                    name = name
                )
            )
        }
    }

    private fun onDocumentChanged(document: String) {
        _state.update {
            RegistrationState.Active(
                stateHolder = state.value.stateHolder.copy(
                    document = document
                )
            )
        }
    }

    private fun onRegisterClicked() {
        _state.update {
            RegistrationState.Loading(
                stateHolder = state.value.stateHolder
            )
        }
    }
}
