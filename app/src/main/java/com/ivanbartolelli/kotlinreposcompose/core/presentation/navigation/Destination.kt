package com.ivanbartolelli.kotlinreposcompose.core.presentation.navigation

sealed class Destination(
    var name: String,
    var route: String
){
    object Repositories : Destination("repositories", Route.Main.route)
    object RepositoryDetail : Destination("repositoryDetail/{id}", Route.Main.route)
}

sealed class Route(
    var route: String
){
    object Main : Route("main")
}