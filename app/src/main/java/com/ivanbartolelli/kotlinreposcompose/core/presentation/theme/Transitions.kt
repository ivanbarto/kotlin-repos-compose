package com.ivanbartolelli.kotlinreposcompose.core.presentation.theme

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally

val exitTransition = slideOutHorizontally(
    targetOffsetX = { -300 },
    animationSpec = tween(durationMillis = 300, easing = FastOutSlowInEasing),
) + fadeOut(animationSpec = tween(300))


val popEnterTransition = slideInHorizontally(
    initialOffsetX = { -300 },
    animationSpec = tween(durationMillis = 300, easing = FastOutSlowInEasing),
) + fadeIn(animationSpec = tween(300))

val popExitTransition = slideOutHorizontally(
    targetOffsetX = { 300 },
    animationSpec = tween(durationMillis = 300, easing = FastOutSlowInEasing),
) + fadeOut(animationSpec = tween(300))

val enterTransition = slideInHorizontally(
    initialOffsetX = { 300 },
    animationSpec = tween(durationMillis = 300, easing = FastOutSlowInEasing),
) + fadeIn(animationSpec = tween(300))

