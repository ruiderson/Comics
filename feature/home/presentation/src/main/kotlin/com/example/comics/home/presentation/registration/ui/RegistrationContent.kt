package com.example.comics.home.presentation.registration.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.comics.home.presentation.registration.interaction.RegistrationIntent
import com.example.comics.home.presentation.registration.interaction.RegistrationStateHolder

@Composable
internal fun RegistrationContent(
    state: RegistrationStateHolder,
    onIntent: (RegistrationIntent) -> Unit
) = Column(
    modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
) {
    TextField(
        value = state.name,
        onValueChange = {
            onIntent(RegistrationIntent.OnNameChanged(it))
        }
    )

    Spacer(Modifier.height(12.dp))

    TextField(
        value = state.document,
        onValueChange = {
            onIntent(RegistrationIntent.OnDocumentChanged(it))
        }
    )

    Spacer(Modifier.height(12.dp))

    Button(
        onClick = {
            onIntent(RegistrationIntent.OnRegisterClicked)
        }
    ) {
        Text("Registrar")
    }
}