package com.example.comics.designsystem.themes.apptheme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color


internal val AppThemeLightColors = lightColorScheme(
    primary = Color(0xFF006DFF),
    onPrimary = Color(0xFFFFFFFF),
    surface = Color(0xFFF5F5F5),
    background = Color(0xFFFFFFFF),
    onBackground = Color(0xFF101010),
    secondary = Color(0xFF6200EE),
)

internal val AppThemeDarkColors = darkColorScheme(
    primary = Color(0xFF86BCFF),
    onPrimary = Color(0xFF003884),
    surface = Color(0xFF121212),
    background = Color(0xFF101010),
    onBackground = Color(0xFFE0E0E0),
    secondary = Color(0xFFBB86FC),
)