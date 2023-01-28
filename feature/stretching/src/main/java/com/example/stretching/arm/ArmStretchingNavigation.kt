package com.example.stretching.arm

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val armStretchingRoute = "arm_stretching_route"

@RequiresApi(Build.VERSION_CODES.O)
fun NavGraphBuilder.armStretchingScreen(
    navigateToFinish: () -> Unit,
    navigateToBack: () -> Unit,
) {
    composable(route = armStretchingRoute) {
        ArmStretchingRoute (navigateToFinish, navigateToBack)
    }
}