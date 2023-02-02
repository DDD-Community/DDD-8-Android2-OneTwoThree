package com.example.stretching.finish

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val stretchingFinishRoute = "stretching_finish_route"

fun NavGraphBuilder.stretchingFinishScreen(
    navigateToBack: () -> Unit,
    navigateToArm: () -> Unit,
    navigateToNeckdown: () -> Unit,
    navigateToNeckup: () -> Unit,
    navigateToShoulder: () -> Unit,
    navigateToWrist: () -> Unit,
) {
    composable(route = stretchingFinishRoute) {
        StretchingFinishRoute(
            navigateToBack,
            navigateToArm,
            navigateToNeckdown,
            navigateToNeckup,
            navigateToShoulder,
            navigateToWrist
        )
    }
}