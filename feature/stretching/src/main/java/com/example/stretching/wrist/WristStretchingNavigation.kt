package com.example.stretching.wrist

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val wristStretchingRoute = "wrist_stretching_route"

fun NavGraphBuilder.wristStretchingScreen(
    navigateToFinish: () -> Unit
) {
    composable(route = wristStretchingRoute) {
        WristStretchingRoute (navigateToFinish)
    }
}