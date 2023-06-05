package com.ivanbartolelli.kotlinreposcompose.core.presentation.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

val black = Color(0xFF000000)
val white = Color(0xFFFFFFFF)
val colorPrimary = Color(0xFFFF5722)
val colorPrimaryVariant = Color(0xFF6A3DE8)

@Immutable
data class BaseColorsPalette(
    val colorPrimary: Color = Color(0xFFFF5722),
    val colorPrimaryVariant: Color = Color(0xFF6A3DE8),
    val profileImageBackground: Color = Color(0xFFFFFFFF),
    val black: Color = Color(0xFF000000),
    val white: Color = Color(0xFFFFFFFF),
    val transparent: Color = Color(0x00FFFFFF),
    val urlContainer: Color = Color(0xFFCFCFCF),
    val snackbarContainer: Color = urlContainer,
    val textButtonText: Color = colorPrimaryVariant
)

val LightCustomColorPalette = BaseColorsPalette()

val DarkCustomColorPalette = BaseColorsPalette(
    urlContainer = Color(0xFF5A5A5A),
    textButtonText = LightCustomColorPalette.colorPrimary,
    profileImageBackground = Color(0xFF252525),

    )
