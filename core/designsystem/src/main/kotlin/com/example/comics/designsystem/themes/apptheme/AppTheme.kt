package com.example.comics.designsystem.themes.apptheme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun AppTheme(
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val scheme = if (isDarkTheme) AppThemeDarkColors else AppThemeLightColors
    MaterialTheme(
        colorScheme = scheme,
        shapes = AppThemeShapes,
        content = content
    )
}
