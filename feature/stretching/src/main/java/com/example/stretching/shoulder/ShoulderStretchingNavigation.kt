package com.example.stretching.shoulder

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.stretching.wrist.WristStretchingRoute

const val shoulderStretchingRoute = "shoulder_stretching_route"

fun NavGraphBuilder.shoulderStretchingScreen(
    navigateToFinish: () -> Unit,
) {
    composable(route = shoulderStretchingRoute) {
        ShoulderStretchingRoute (navigateToFinish, )
    }
}