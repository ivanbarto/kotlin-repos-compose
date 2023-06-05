package com.ivanbartolelli.kotlinreposcompose.features.repositories.presentation.repositories

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ivanbartolelli.kotlinreposcompose.R
import com.ivanbartolelli.kotlinreposcompose.core.presentation.composables.MessageSnackbar
import com.ivanbartolelli.kotlinreposcompose.core.presentation.theme.KotlinReposComposeTheme
import com.ivanbartolelli.kotlinreposcompose.features.repositories.domain.models.Repository

@Composable
fun RepositoriesScreen() {

    val scaffoldState = rememberScaffoldState()
    val repositories = remember {
        mutableStateOf(listOf<Repository>())
    }

    Scaffold(
        scaffoldState = scaffoldState,
        snackbarHost = { MessageSnackbar(snackbarHostState = scaffoldState.snackbarHostState) },
    ) { innerPading ->

        Box(

        ) {

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize(1f)
                    .padding(innerPading)
            ) {
                item {
                    Text(
                        text = stringResource(id = R.string.text_repositories),
                        style = MaterialTheme.typography.h5,
                        modifier = Modifier.padding(20.dp),
                        fontWeight = FontWeight.Bold
                    )
                }
                itemsIndexed(repositories.value) { _, repository ->
                    RepositoryItem()
                    Divider()
                }
                item {
                    RepositoryItem()
                    Divider()
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    KotlinReposComposeTheme {
        RepositoriesScreen()
    }
}