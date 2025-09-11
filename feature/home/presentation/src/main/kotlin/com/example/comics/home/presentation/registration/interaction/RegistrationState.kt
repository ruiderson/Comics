package com.example.comics.home.presentation.registration.interaction

import androidx.compose.runtime.Immutable

@Immutable
internal sealed interface RegistrationState {
    val stateHolder: RegistrationStateHolder

    @Immutable
    data class Loading(override val stateHolder: RegistrationStateHolder) : RegistrationState
    @Immutable
    data class Error(override val stateHolder: RegistrationStateHolder) : RegistrationState
    @Immutable
    data class Active(override val stateHolder: RegistrationStateHolder) : RegistrationState
}
