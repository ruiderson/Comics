package com.example.comics.home.presentation.registration.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.comics.domain.models.Comic
import com.example.comics.home.presentation.registration.interaction.RegistrationViewModel
import com.example.comics.presentation.interaction.onEffectChanged
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun RegistrationScreen(
    onNavigateToDetails: (Comic) -> Unit,
    viewModel: RegistrationViewModel = koinViewModel()
) {
    val state = viewModel.state.collectAsStateWithLifecycle()

    viewModel.effect.onEffectChanged { }

    RegistrationScaffold(
        state = state.value,
        onIntent = viewModel::onIntent
    )
}
