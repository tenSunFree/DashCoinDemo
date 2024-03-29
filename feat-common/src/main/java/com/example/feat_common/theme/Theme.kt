package com.example.feat_common.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = CustomGreen,
    background = DarkGray,
    onBackground = TextWhite,
    onPrimary = LightGray
)

private val LightColorPalette = lightColors(
    primary = CustomGreen,
    background = DarkGray,
    onBackground = TextWhite,
    onPrimary = LightGray
)

@Composable
fun DashCoinTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }
    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}