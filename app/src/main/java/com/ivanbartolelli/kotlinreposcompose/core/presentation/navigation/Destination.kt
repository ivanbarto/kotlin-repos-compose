package com.ivanbartolelli.kotlinreposcompose.core.presentation.navigation

sealed class Destination(
    var name: String,
    var route: String
){
    object Repositories : Destination("repositories", Route.Main.route)
    object RepositoryDetail : Destination("repositoryDetail/", Route.Main.route)
}

object DestinationParameters {
    const val REPOSITORY_ID = "{id}"
}

sealed class Route(
    var route: String
){
    object Main : Route("main")
}