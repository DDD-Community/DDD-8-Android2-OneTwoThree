package com.example.stretching.neckup

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val neckupStretchingRoute = "neckup_stretching_route"

@RequiresApi(Build.VERSION_CODES.O)
fun NavGraphBuilder.neckupStretchingScreen(
    navigateToFinish: () -> Unit,
    navigateToBack: () -> Unit,
) {
    composable(route = neckupStretchingRoute) {
        NeckupStretchingRoute (
            navigateToFinish = navigateToFinish,
            navigateToBack = navigateToBack
        )
    }
}