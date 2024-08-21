package com.fcerio.ota.android.presentation.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Navigation.Routes.DASHBOARD
    ) {
        composable(
            route = Navigation.Routes.DASHBOARD
        ) {
            DashboardScreenDestination(navController)
        }
    }
}

object Navigation {
    object Routes {
        const val DASHBOARD = "dashboard"
    }
}