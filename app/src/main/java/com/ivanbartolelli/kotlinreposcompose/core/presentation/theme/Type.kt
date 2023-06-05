package com.ivanbartolelli.kotlinreposcompose.core.presentation.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
val LightTypography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        color = black
    ),
    h5 = TextStyle(
        color = black,
        fontWeight = FontWeight.Bold,
    ),
    h6 = TextStyle(
        color = black,
        fontWeight = FontWeight.Bold,
    )
)

val DarkTypography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        color = white
    ),
    h5 = TextStyle(
        color = white,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
    ),
    h6 = TextStyle(
        color = white,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
    )
)