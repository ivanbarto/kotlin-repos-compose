package com.ivanbartolelli.kotlinreposcompose.core.presentation.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val colorPrimary = Color(0xFFFF5722)
val colorPrimaryVariant = Color(0xFF6A3DE8)
val black = Color(0xFF000000)
val white = Color(0xFFFFFFFF)
val transparent = Color(0x00FFFFFF)
val urlContainer = Color(0xFFCFCFCF)
val snackbarContainer = urlContainer
val textButtonTextColor = colorPrimaryVariant

@Immutable
data class BaseColorsPalette(
    val colorPrimary: Color = Color(0xFFFF5722),
    val colorPrimaryVariant: Color = Color(0xFF6A3DE8),
    val black: Color = Color(0xFF000000),
    val white: Color = Color(0xFFFFFFFF),
    val transparent: Color = Color(0x00FFFFFF),
    val urlContainer: Color = Color(0xFFCFCFCF),
    val snackbarContainer: Color = urlContainer,
    val textButtonTextColor: Color = colorPrimaryVariant
)

val LightCustomColorPalette = BaseColorsPalette()

val DarkCustomColorPalette = BaseColorsPalette(
    urlContainer = Color(0xFF5A5A5A),
    textButtonTextColor = colorPrimary
)
