package com.example.comics.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.comics.home.presentation.home.ui.HomeScreen

@Composable
fun AppNavGraph(
    startDestination: Destinations = Destinations.Home,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = Modifier.fillMaxSize().background(Color.Black),
    ) {
        composable<Destinations.Home> {
            HomeScreen(
                onNavigateToDetails = { }
            )
        }
    }
}