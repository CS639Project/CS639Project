package com.example.kindnessjar.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.material3.lightColorScheme

private val LightColors = lightColorScheme(
    background = PeachBackground,
    primary = SoftTeal,
    secondary = SoftGreen,
    surface = LightCard,
    onSurface = TextBlack,
    onPrimary = TextWhite
)

@Composable
fun KindnessJarTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = LightColors,
        typography = AppTypography,
        shapes = AppShapes,
        content = content
    )
}
