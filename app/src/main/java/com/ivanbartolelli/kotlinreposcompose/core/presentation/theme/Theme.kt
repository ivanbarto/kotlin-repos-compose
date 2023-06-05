package com.ivanbartolelli.kotlinreposcompose.core.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf

private val DarkColorPalette = darkColors(
    primary = colorPrimary,
    primaryVariant = colorPrimaryVariant,
    onPrimary = black,

)

private val LightColorPalette = lightColors(
    primary = colorPrimary,
    primaryVariant = colorPrimaryVariant,
    onPrimary = white,
)


private val LocalCustomColorsPalette = staticCompositionLocalOf { BaseColorsPalette() }

val MaterialTheme.customColorsPalette: BaseColorsPalette
    @Composable
    @ReadOnlyComposable
    get() = LocalCustomColorsPalette.current


@Composable
fun KotlinReposComposeTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {

    val colors = if (darkTheme) DarkColorPalette else LightColorPalette
    val customColorsPalette = if (darkTheme) DarkCustomColorPalette else LightCustomColorPalette

    CompositionLocalProvider(
        LocalCustomColorsPalette provides customColorsPalette
    ) {
        MaterialTheme(
            colors = colors,
            shapes = Shapes,
            content = content
        )
    }
}