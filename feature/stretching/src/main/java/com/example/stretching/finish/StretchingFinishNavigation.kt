package com.example.stretching.finish

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

const val stretchingFinishRoute = "stretching_finish_route/{name}"

fun NavGraphBuilder.stretchingFinishScreen(
    navigateToBack: () -> Unit,
    navigateToArm: () -> Unit,
    navigateToNeckdown: () -> Unit,
    navigateToNeckup: () -> Unit,
    navigateToShoulder: () -> Unit,
    navigateToWrist: () -> Unit,
) {
    composable(route = stretchingFinishRoute,
        arguments = listOf(navArgument("name") {
            type = NavType.StringType
        })
    ) { backStackEntry ->
        StretchingFinishRoute(
            navigateToBack,
            navigateToArm,
            navigateToNeckdown,
            navigateToNeckup,
            navigateToShoulder,
            navigateToWrist,
            backStackEntry.arguments?.getString("name")
        )
    }
}