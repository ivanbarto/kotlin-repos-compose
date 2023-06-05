package com.ivanbartolelli.kotlinreposcompose.features.repositories.presentation.repositories

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.os.bundleOf
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import com.ivanbartolelli.kotlinreposcompose.R
import com.ivanbartolelli.kotlinreposcompose.core.presentation.composables.MessageSnackbar
import com.ivanbartolelli.kotlinreposcompose.core.presentation.navigation.Destination
import com.ivanbartolelli.kotlinreposcompose.core.presentation.theme.KotlinReposComposeTheme
import com.ivanbartolelli.kotlinreposcompose.features.repositories.domain.models.Repository
import com.ivanbartolelli.kotlinreposcompose.features.repositories.presentation.utils.BundleConstants.KEY_REPOSITORY
import com.ivanbartolelli.kotlinreposcompose.features.repositories.presentation.utils.DisplayConstants.ITEM_DEFAULT_KEY

@Composable
fun RepositoriesScreen(viewModel: RepositoriesViewModel = hiltViewModel(), navHostController: NavHostController) {

    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    val repositories = viewModel.repositories.collectAsLazyPagingItems()

    Scaffold(
        scaffoldState = scaffoldState,
        snackbarHost = { MessageSnackbar(snackbarHostState = scaffoldState.snackbarHostState) },
    ) { innerPadding ->

        Box(

        ) {

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
                            navHostController.navigate("repositoryDetail/${repository.id}")
                        }
                        Divider()
                    }
                }
            }
        }
    }

}
