package com.inseoul.onborading.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.inseoul.onborading.OnBoardingRoute

const val onBoardingRoute = "on_boarding_route"

fun NavGraphBuilder.onBoardingScreen() {
    composable(route = onBoardingRoute) {
        OnBoardingRoute()
    }
}
