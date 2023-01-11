package com.inseoul.onboarding.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.inseoul.onboarding.OnBoardingRoute

const val onBoardingRoute = "on_boarding_route"

fun NavGraphBuilder.onBoardingScreen(navigate: () -> Unit) {
    composable(route = onBoardingRoute) {
        OnBoardingRoute(navigate)
    }
}
