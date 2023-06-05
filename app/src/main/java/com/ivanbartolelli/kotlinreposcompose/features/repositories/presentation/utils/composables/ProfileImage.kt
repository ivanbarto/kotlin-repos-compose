package com.ivanbartolelli.kotlinreposcompose.features.repositories.presentation.utils.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.ivanbartolelli.kotlinreposcompose.R

@Composable
fun ProfileImage() {
    Card(modifier = Modifier.clip(CircleShape), elevation = 3.dp) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data("https://picsum.photos/200")
                .crossfade(true)
                .build(),
            placeholder = painterResource(R.drawable.ic_user),
            contentDescription = stringResource(R.string.text_github_user),
            modifier = Modifier
                .size(70.dp)
                .background(MaterialTheme.colors.background),
        )
    }
}