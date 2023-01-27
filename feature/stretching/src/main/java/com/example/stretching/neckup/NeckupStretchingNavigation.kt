package com.example.stretching.neckup

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.stretching.shoulder.ShoulderStretchingRoute

const val neckupStretchingRoute = "neckup_stretching_route"

fun NavGraphBuilder.neckupStretchingScreen(
    navigateToFinish: () -> Unit,
) {
    composable(route = neckupStretchingRoute) {
        NeckupStretchingRoute (navigateToFinish, )
    }
}