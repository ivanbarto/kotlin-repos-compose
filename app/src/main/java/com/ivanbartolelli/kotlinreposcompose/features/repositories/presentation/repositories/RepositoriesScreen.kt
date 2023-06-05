package com.ivanbartolelli.kotlinreposcompose.features.repositories.presentation.repositories

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.ivanbartolelli.kotlinreposcompose.R
import com.ivanbartolelli.kotlinreposcompose.core.presentation.composables.MessageSnackbar
import com.ivanbartolelli.kotlinreposcompose.core.presentation.navigation.Destination
import com.ivanbartolelli.kotlinreposcompose.features.repositories.presentation.utils.DisplayConstants.ITEM_DEFAULT_KEY

@Composable
fun RepositoriesScreen(viewModel: RepositoriesViewModel = hiltViewModel(), navHostController: NavHostController) {

    val scaffoldState = rememberScaffoldState()
    var repositories = viewModel.repositories.collectAsLazyPagingItems()
    val refreshState = repositories.loadState.refresh

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
                    Text(
                        text = stringResource(id = R.string.text_repositories),
                        style = MaterialTheme.typography.h5,
                        modifier = Modifier.padding(20.dp),
                        fontWeight = FontWeight.Bold
                    )
                }

                items(
                    count = repositories.itemCount,
                    key = { key ->
                        repositories[key]?.id
                            ?: ITEM_DEFAULT_KEY
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
                    RepositoriesLoadState(loadState = refreshState) {
                        repositories.retry()
                    }
                }
            }
        }
    }
}

@Composable
fun RepositoriesLoadState(loadState: LoadState, onRetry : () -> Unit) {

    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
        .fillMaxWidth()
        .padding(top = 10.dp)) {
        when (loadState) {
            is LoadState.NotLoading -> Unit
            is LoadState.Loading -> {
                CircularProgressIndicator()
            }
            is LoadState.Error -> {
                Text(
                    text = loadState.error.message
                        ?: stringResource(id = R.string.text_not_connected),
                    style = MaterialTheme.typography.caption
                )
                TextButton(onClick = { onRetry() }) {
                    Text(text = stringResource(id = R.string.text_retry).uppercase(), color = MaterialTheme.colors.primary)
                }
            }
        }
    }
}
