package com.example.stretching.finish

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val stretchingFinishRoute = "stretching_finish_route"

fun NavGraphBuilder.stretchingFinishScreen() {
    composable(route = stretchingFinishRoute) {
        StretchingFinishRoute() // 경로 추가
    }
}