package com.ivanbartolelli.kotlinreposcompose.features.repositories.presentation.repositories

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.LoadState
import androidx.paging.LoadStates
import androidx.paging.compose.collectAsLazyPagingItems
import com.ivanbartolelli.kotlinreposcompose.R
import com.ivanbartolelli.kotlinreposcompose.core.presentation.composables.MessageSnackbar
import com.ivanbartolelli.kotlinreposcompose.core.presentation.navigation.Destination
import kotlinx.coroutines.launch
import kotlin.random.Random

@Composable
fun RepositoriesScreen(viewModel: RepositoriesViewModel = hiltViewModel(), navHostController: NavHostController) {

    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    val repositories = viewModel.repositories.collectAsLazyPagingItems()

    Scaffold(
        scaffoldState = scaffoldState,
        snackbarHost = { MessageSnackbar(snackbarHostState = scaffoldState.snackbarHostState) },
    ) { innerPadding ->


        Box() {

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize(1f)
                    .padding(innerPadding)
            ) {
                item {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = stringResource(id = R.string.text_repositories),
                            style = MaterialTheme.typography.h5,
                            modifier = Modifier.padding(20.dp),
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(
                            modifier = Modifier
                                .width(0.dp)
                                .weight(1f)
                        )
                        IconButton(onClick = {
                            coroutineScope.launch {
                                viewModel.clearRepositoriesCache()
                                repositories.refresh()
                            }
                        }) {
                            Icon(
                                imageVector = ImageVector.vectorResource(id = R.drawable.ic_clean_cache),
                                contentDescription = stringResource(
                                    R.string.text_clean_cache
                                )
                            )
                        }
                    }
                }

                items(
                    count = repositories.itemCount,
                    key = { key ->
                        repositories[key]?.id
                            ?: Random.nextLong()
                    },
                    contentType = { }
                ) { index ->
                    repositories[index]?.let {
                        RepositoryItem(it) { repository ->
                            navHostController.navigate(Destination.RepositoryDetail.name + repository.id)
                        }
                        Divider()
                    }
                }

                item {
                    RefreshLoadState(loadState = repositories.loadState.refresh) {
                        repositories.retry()
                    }
                }
            }
        }
    }
}

@Composable
fun RefreshLoadState(loadState: LoadState, onRetry: () -> Unit) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp)
    ) {
        when (loadState) {
            is LoadState.NotLoading -> Unit
            is LoadState.Loading -> {
                CircularProgressIndicator()
            }
            is LoadState.Error -> {
                ErrorState(loadState, onRetry)
            }
        }
    }
}

@Composable
private fun ErrorState(loadState: LoadState.Error, onRetry: () -> Unit) {

    Text(
        text = stringResource(
            id = R.string.text_error,
            loadState.error.message
                ?: stringResource(R.string.text_generic_error)
        ),
        style = MaterialTheme.typography.caption,
        modifier = Modifier.padding(horizontal = 20.dp),
        textAlign = TextAlign.Center
    )
    TextButton(onClick = { onRetry() }) {
        Text(text = stringResource(id = R.string.text_retry).uppercase(), color = MaterialTheme.colors.primary)
    }
}

