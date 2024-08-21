package com.fcerio.ota.android.presentation.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.fcerio.ota.android.features.dashboard.DashboardScreen
import com.fcerio.ota.android.features.dashboard.DashboardViewModel

@Composable
fun DashboardScreenDestination(navController: NavController) {
    val viewModel = hiltViewModel<DashboardViewModel>()
    DashboardScreen(
        state = viewModel.viewState.value,
        effectFlow = viewModel.effect,
        onEventSent = { event ->  viewModel.setEvent(event) },
        onNavigationRequested = {
        }
    )
}
