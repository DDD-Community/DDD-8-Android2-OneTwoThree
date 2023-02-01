package com.example.stretching.finish

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val stretchingFinishRoute = "stretching_finish_route"

fun NavGraphBuilder.stretchingFinishScreen(
    navigateToBack: () -> Unit,
) {
    composable(route = stretchingFinishRoute) {
        StretchingFinishRoute(navigateToBack) // 경로 추가
    }
}