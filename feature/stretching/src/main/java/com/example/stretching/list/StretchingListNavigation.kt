package com.example.stretching.list

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val stretchingListRoute = "stretching_list_route"

fun NavGraphBuilder.stretchingListScreen(
    navigateToBack: () -> Unit,
    navigateToArm: () -> Unit,
    navigateToNeckdown: () -> Unit,
    navigateToNeckup: () -> Unit,
    navigateToShoulder: () -> Unit,
    navigateToWrist: () -> Unit
) {
    composable(route = stretchingListRoute) {
        StretchingListRoute(
            navigateToBack,
            navigateToArm,
            navigateToNeckdown,
            navigateToNeckup,
            navigateToShoulder,
            navigateToWrist
            )
    }
}