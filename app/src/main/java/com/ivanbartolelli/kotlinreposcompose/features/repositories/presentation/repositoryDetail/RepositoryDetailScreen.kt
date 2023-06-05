package com.ivanbartolelli.kotlinreposcompose.features.repositories.presentation.repositoryDetail

import android.widget.Space
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ivanbartolelli.kotlinreposcompose.R
import com.ivanbartolelli.kotlinreposcompose.core.presentation.composables.MessageSnackbar
import com.ivanbartolelli.kotlinreposcompose.core.presentation.theme.KotlinReposComposeTheme
import com.ivanbartolelli.kotlinreposcompose.core.presentation.theme.customColorsPalette
import com.ivanbartolelli.kotlinreposcompose.features.repositories.presentation.utils.composables.ProfileImage
import com.ivanbartolelli.kotlinreposcompose.features.repositories.presentation.utils.composables.Url
import com.ivanbartolelli.kotlinreposcompose.features.repositories.presentation.utils.composables.WatchersCounter

@Composable fun RepositoryDetailScreen() {
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        snackbarHost = { MessageSnackbar(snackbarHostState = scaffoldState.snackbarHostState) },
    ) { innerPading ->

        Column(
            Modifier
                .fillMaxSize()
                .padding(innerPading), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TopAppBar(backgroundColor = MaterialTheme.customColorsPalette.transparent, elevation = 0.dp) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Rounded.ArrowBack,
                        tint = MaterialTheme.colors.onBackground,
                        contentDescription = stringResource(R.string.text_return),
                        modifier = Modifier
                            .size(40.dp)
                            .padding(10.dp)

                    )
                }

                Spacer(
                    modifier = Modifier
                        .width(0.dp)
                        .weight(1f)
                )

                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_share),
                        contentDescription = stringResource(R.string.text_share),
                        tint = MaterialTheme.colors.onBackground,
                        modifier = Modifier
                            .size(40.dp)
                            .padding(10.dp)

                    )
                }


            }

            Text(
                text = "Repo/name/name/nameeeadsasdasde",
                maxLines = 1,
                style = MaterialTheme.typography.h4,
                modifier = Modifier.padding(10.dp),
                textAlign = TextAlign.Center,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.Bold
            )

            ProfileImage()

            Text(
                text = "ivan_bartolelli",
                style = MaterialTheme.typography.subtitle1,
                modifier = Modifier.padding(top = 10.dp)
            )

            TextButton(onClick = { /*TODO*/ }) {
                Text(
                    text = stringResource(R.string.text_view_github),
                    style = MaterialTheme.typography.body1,
                    color = MaterialTheme.customColorsPalette.textButtonText,
                    fontWeight = FontWeight.Bold
                )
            }

            Text(
                text = "This is an awesome repo. Hope you like.",
                style = MaterialTheme.typography.subtitle1,
                modifier = Modifier
                    .padding(top = 48.dp, end = 10.dp, start = 10.dp)
                    .fillMaxWidth()
            )

            Row(Modifier.padding(10.dp)) {
                WatchersCounter()
                Spacer(
                    modifier = Modifier
                        .width(0.dp)
                        .weight(1f)
                )
            }

            Text(
                text = "Created at: 22/10/2020",
                style = MaterialTheme.typography.caption,
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .fillMaxWidth()
            )
            Text(
                text = "Last update: 22/10/2020",
                style = MaterialTheme.typography.caption,
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
            )


            Text(
                text = stringResource(R.string.text_http),
                style = MaterialTheme.typography.body1,
                modifier = Modifier
                    .padding(start = 10.dp, end = 10.dp, top = 24.dp)
                    .fillMaxWidth()
            )

            Url()

            Text(
                text = stringResource(R.string.text_ssh),
                style = MaterialTheme.typography.body1,
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .fillMaxWidth()
            )

            Url()


        }
    }

}


@Preview(showBackground = true) @Composable fun RepositoryDetailScreenPreview() {
    KotlinReposComposeTheme {
        RepositoryDetailScreen()
    }
}