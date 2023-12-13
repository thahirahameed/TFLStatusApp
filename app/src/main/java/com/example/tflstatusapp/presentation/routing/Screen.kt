package com.example.tflstatusapp.presentation.routing

sealed class Screen(val route: String){

    object TubeListingScreen: Screen("home")
}
