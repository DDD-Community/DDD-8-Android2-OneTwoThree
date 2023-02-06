package com.example.stretching.neckdown

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val neckdownStretchingRoute = "neckdown_stretching_route"

@RequiresApi(Build.VERSION_CODES.O)
fun NavGraphBuilder.neckdownStretchingScreen(
    navigateToFinish: () -> Unit,
    navigateToBack: () -> Unit,
) {
    composable(route = neckdownStretchingRoute) {
        NeckdownStretchingRoute (navigateToFinish, navigateToBack)
    }
}