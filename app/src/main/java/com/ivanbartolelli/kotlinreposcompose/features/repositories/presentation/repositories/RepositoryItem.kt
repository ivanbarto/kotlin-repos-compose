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
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.ivanbartolelli.kotlinreposcompose.R
import com.ivanbartolelli.kotlinreposcompose.core.presentation.theme.KotlinReposComposeTheme

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
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data("https://picsum.photos/200")
                .crossfade(true)
                .build(),
            placeholder = painterResource(R.drawable.ic_user),
            contentDescription = stringResource(R.string.text_github_user),
            //            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(70.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colors.background),
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp)
        ) {
            Text(
                text = "google/repos",
                style = MaterialTheme.typography.h6,
                overflow = TextOverflow.Ellipsis
            )

            Text(text = "By ivi DXC")

            Row() {
                Spacer(
                    modifier = Modifier
                        .width(0.dp)
                        .weight(1f)
                )
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_eye),
                    tint = MaterialTheme.colors.onBackground,
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
                Text(text = "123234")
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