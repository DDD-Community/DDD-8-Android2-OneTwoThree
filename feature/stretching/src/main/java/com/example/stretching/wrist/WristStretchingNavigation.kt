package com.example.stretching.wrist

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val wristStretchingRoute = "wrist_stretching_route"

@RequiresApi(Build.VERSION_CODES.O)
fun NavGraphBuilder.wristStretchingScreen(
    navigateToFinish: () -> Unit,
    navigateToBack: () -> Unit,
) {
    composable(route = wristStretchingRoute) {
        WristStretchingRoute (navigateToFinish, navigateToBack)
    }
}