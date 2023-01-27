package com.example.stretching.arm

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val armStretchingRoute = "arm_stretching_route"

fun NavGraphBuilder.armStretchingScreen(
    navigateToFinish: () -> Unit,
) {
    composable(route = armStretchingRoute) {
        ArmStretchingRoute (navigateToFinish)
    }
}