package com.example.tflstatusapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tflstatusapp.presentation.routing.Screen
import com.example.tflstatusapp.presentation.screens.TubeLineStatusScreen
import com.example.tflstatusapp.presentation.viewmodel.TubeLineStatusViewModel

@Composable
fun Navigation(){
    val navHostController = rememberNavController()
    
    val viewModel: TubeLineStatusViewModel = hiltViewModel()
    
    NavHost(navController = navHostController,
        startDestination = Screen.TubeListingScreen.route){
        composable(route = Screen.TubeListingScreen.route){
            TubeLineStatusScreen(navHostController = navHostController, viewModel = viewModel)
        }
    }
}