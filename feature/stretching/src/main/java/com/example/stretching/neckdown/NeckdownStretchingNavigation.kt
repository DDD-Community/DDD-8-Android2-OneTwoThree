package com.example.stretching.neckdown

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val neckdownStretchingRoute = "neckdown_stretching_route"

fun NavGraphBuilder.neckdownStretchingScreen(
    navigateToFinish: () -> Unit
) {
    composable(route = neckdownStretchingRoute) {
        NeckdownStretchingRoute (navigateToFinish)
    }
}