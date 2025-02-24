package com.example.chatpulse.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.chatpulse.ui.screens.HomeScreen
import com.example.chatpulse.ui.screens.AnalysisScreen

@Composable
fun ChatPulseNavHost() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(navController)
        }
        composable("analysis") {
            AnalysisScreen(navController)
        }
    }
}