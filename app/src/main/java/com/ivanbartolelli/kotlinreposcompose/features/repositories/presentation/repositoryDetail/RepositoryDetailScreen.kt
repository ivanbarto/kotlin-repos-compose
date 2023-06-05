package com.ivanbartolelli.kotlinreposcompose.features.repositories.presentation.repositoryDetail

import android.content.Context
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
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import com.ivanbartolelli.kotlinreposcompose.R
import com.ivanbartolelli.kotlinreposcompose.core.presentation.composables.MessageSnackbar
import com.ivanbartolelli.kotlinreposcompose.core.presentation.composables.SnackbarType
import com.ivanbartolelli.kotlinreposcompose.core.presentation.theme.customColorsPalette
import com.ivanbartolelli.kotlinreposcompose.features.repositories.domain.models.Repository
import com.ivanbartolelli.kotlinreposcompose.features.repositories.presentation.repositories.RepositoriesViewModel
import com.ivanbartolelli.kotlinreposcompose.features.repositories.presentation.utils.DateUtils
import com.ivanbartolelli.kotlinreposcompose.features.repositories.presentation.utils.IntentUtils
import com.ivanbartolelli.kotlinreposcompose.features.repositories.presentation.utils.ShareUtils
import com.ivanbartolelli.kotlinreposcompose.features.repositories.presentation.utils.composables.ProfileImage
import com.ivanbartolelli.kotlinreposcompose.features.repositories.presentation.utils.composables.Url
import com.ivanbartolelli.kotlinreposcompose.features.repositories.presentation.utils.composables.WatchersCounter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable fun RepositoryDetailScreen(
    navHostController: NavHostController,
    backStackEntry: NavBackStackEntry,
    repositoriesViewModel: RepositoriesViewModel = hiltViewModel()
) {

    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        snackbarHost = { MessageSnackbar(snackbarHostState = scaffoldState.snackbarHostState) },
    ) { innerPadding ->


        val repository: Repository = remember {
            repositoriesViewModel.getRepository(
                backStackEntry.arguments?.getString("id")?.toLong()
                    ?: 1L
            )
        }

        val context = LocalContext.current

        Column(
            Modifier
                .fillMaxSize()
                .padding(innerPadding), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TopAppBar(backgroundColor = MaterialTheme.customColorsPalette.transparent, elevation = 0.dp) {
                IconButton(onClick = { navHostController.navigateUp() }) {
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

                repository.urlAsUri()?.let { uri ->
                    IconButton(onClick = {
                        ShareUtils.shareText(context, context.getString(R.string.text_share_url_message, repository.urlAsUri()))
                    }) {
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


            }

            Text(
                text = repository.name
                    ?: stringResource(id = R.string.text_no_name),
                maxLines = 1,
                style = MaterialTheme.typography.h4,
                modifier = Modifier.padding(10.dp),
                textAlign = TextAlign.Center,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.Bold
            )

            ProfileImage(
                repository.owner?.avatarUrl
            )

            Text(
                text = repository.owner?.userName
                    ?: stringResource(id = R.string.text_no_username),
                style = MaterialTheme.typography.subtitle1,
                modifier = Modifier.padding(top = 10.dp)
            )

            TextButton(onClick = {
                repository.urlAsUri()?.let { uri ->
                    IntentUtils.openURLInBrowser(context, uri)
                }
            }) {
                Text(
                    text = stringResource(R.string.text_view_github),
                    style = MaterialTheme.typography.body1,
                    color = MaterialTheme.customColorsPalette.textButtonText,
                    fontWeight = FontWeight.Bold
                )
            }

            Text(
                text = repository.description
                    ?: stringResource(R.string.text_no_description),
                style = MaterialTheme.typography.subtitle1,
                modifier = Modifier
                    .padding(top = 48.dp, end = 10.dp, start = 10.dp)
                    .fillMaxWidth()
            )

            Row(Modifier.padding(10.dp)) {
                WatchersCounter(repository.watchersCount.toString())
                Spacer(
                    modifier = Modifier
                        .width(0.dp)
                        .weight(1f)
                )
            }

            repository.updatedAt?.let {
                Text(
                    text = stringResource(id = R.string.text_last_update, DateUtils.getShortDateString(it)),
                    style = MaterialTheme.typography.caption,
                    modifier = Modifier
                        .padding(horizontal = 10.dp)
                        .fillMaxWidth()
                )
            }

            repository.createdAt?.let {
                Text(
                    text = stringResource(id = R.string.text_created_at, DateUtils.getShortDateString(it)),
                    style = MaterialTheme.typography.caption,
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth()
                )
            }


            repository.gitUrl?.let {
                Text(
                    text = stringResource(R.string.text_http),
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier
                        .padding(start = 10.dp, end = 10.dp, top = 24.dp)
                        .fillMaxWidth()
                )
                Url(repository.gitUrl) {
                    ShareUtils.copyToClipboard(repository.gitUrl, context)
                    showCopiedMessage(coroutineScope, scaffoldState, context)
                }

            }

            repository.sshUrl?.let {
                Text(
                    text = stringResource(R.string.text_ssh),
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier
                        .padding(horizontal = 10.dp)
                        .fillMaxWidth()
                )

                Url(repository.sshUrl) {
                    ShareUtils.copyToClipboard(repository.sshUrl, context)
                    showCopiedMessage(coroutineScope, scaffoldState, context)
                }
            }

        }
    }

}

private fun showCopiedMessage(
    coroutineScope: CoroutineScope,
    scaffoldState: ScaffoldState,
    context: Context
) {
    coroutineScope.launch {
        scaffoldState.snackbarHostState.showSnackbar(
            context.getString(R.string.text_copied),
            SnackbarType.INFO.ordinal.toString()
        )
    }
}
