package com.ivanbartolelli.kotlinreposcompose.features.repositories.presentation.repositories

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.ivanbartolelli.kotlinreposcompose.R
import com.ivanbartolelli.kotlinreposcompose.core.presentation.theme.KotlinReposComposeTheme
import com.ivanbartolelli.kotlinreposcompose.features.repositories.presentation.utils.composables.ProfileImage
import com.ivanbartolelli.kotlinreposcompose.features.repositories.presentation.utils.composables.WatchersCounter

@Composable
fun RepositoryItem() {


    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {

            }
            .padding(bottom = 10.dp)
            .padding(10.dp)
    ) {
        ProfileImage()

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp)
        ) {
            Text(
                text = "google/repos",
                style = MaterialTheme.typography.h6,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.Bold
            )

            Text(text = "By ivi DXC", style = MaterialTheme.typography.body2)

            Row() {
                Spacer(
                    modifier = Modifier
                        .width(0.dp)
                        .weight(1f)
                )
                WatchersCounter()
            }

        }

    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    KotlinReposComposeTheme {
        RepositoryItem()
    }
}