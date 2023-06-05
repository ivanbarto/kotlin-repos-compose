package com.ivanbartolelli.kotlinreposcompose.core.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.ivanbartolelli.kotlinreposcompose.core.presentation.navigation.Destination
import com.ivanbartolelli.kotlinreposcompose.core.presentation.theme.KotlinReposComposeTheme
import com.ivanbartolelli.kotlinreposcompose.core.presentation.theme.enterTransition
import com.ivanbartolelli.kotlinreposcompose.core.presentation.theme.exitTransition
import com.ivanbartolelli.kotlinreposcompose.core.presentation.theme.popEnterTransition
import com.ivanbartolelli.kotlinreposcompose.core.presentation.theme.popExitTransition
import com.ivanbartolelli.kotlinreposcompose.features.repositories.domain.models.Repository
import com.ivanbartolelli.kotlinreposcompose.features.repositories.presentation.repositories.RepositoriesScreen
import com.ivanbartolelli.kotlinreposcompose.features.repositories.presentation.repositoryDetail.RepositoryDetailScreen
import com.ivanbartolelli.kotlinreposcompose.features.repositories.presentation.utils.BundleConstants.KEY_REPOSITORY
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KotlinReposComposeTheme {

                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    MainNavigation()
                }
            }
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
private fun MainNavigation() {
    val navController = rememberAnimatedNavController()

    AnimatedNavHost(navController = navController, startDestination = Destination.Repositories.name) {

        composable(Destination.Repositories.name,
                   exitTransition = { exitTransition },
                   popEnterTransition = { popEnterTransition },
                   popExitTransition = { popExitTransition },
                   enterTransition = { enterTransition }
        ) { RepositoriesScreen(navHostController = navController) }

        composable(Destination.RepositoryDetail.name,
                   exitTransition = { exitTransition },
                   popEnterTransition = { popEnterTransition },
                   popExitTransition = { popExitTransition },
                   enterTransition = { enterTransition }
        ) { backStackEntry ->
            RepositoryDetailScreen(navHostController = navController, backStackEntry = backStackEntry)

        }
    }
}


