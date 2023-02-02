package com.example.stretching.shoulder

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.stretching.wrist.WristStretchingRoute

const val shoulderStretchingRoute = "shoulder_stretching_route"


@RequiresApi(Build.VERSION_CODES.O)
fun NavGraphBuilder.shoulderStretchingScreen(
    navigateToFinish: () -> Unit,
    navigateToBack: () -> Unit,
) {
    composable(route = shoulderStretchingRoute) {
        ShoulderStretchingRoute (navigateToFinish, navigateToBack)
    }
}