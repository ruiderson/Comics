package com.example.comics.home.presentation.registration.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.comics.home.presentation.registration.interaction.RegistrationIntent
import com.example.comics.home.presentation.registration.interaction.RegistrationStateHolder
import com.example.comics.home.presentation.registration.interaction.RegistrationUiState

@Composable
internal fun RegistrationScaffold(
    state: RegistrationStateHolder,
    onIntent: (RegistrationIntent) -> Unit
) = when(state.uiState) {
    is RegistrationUiState.Loading -> LoadingScreen()
    is RegistrationUiState.Error -> ErrorScreen(onTryAgain = {})
    is RegistrationUiState.Active -> RegistrationContent(
        state = state,
        onIntent = onIntent
    )
}

@Composable
private fun LoadingScreen() = Box(
    modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
) {
    CircularProgressIndicator(
        modifier = Modifier
            .size(60.dp)
            .align(Alignment.Center)
    )
}

@Composable
private fun ErrorScreen(
    onTryAgain: () -> Unit
) = Box(
    modifier = Modifier
        .fillMaxSize()
        .background(Color.Red)
        .clickable { onTryAgain() }
) {
    Text(
        text = "Something went wrong",
        color = Color.White,
        fontSize = 16.sp,
        modifier = Modifier.align(Alignment.Center)
    )
}
