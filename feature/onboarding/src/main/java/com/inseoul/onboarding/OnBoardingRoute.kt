package com.inseoul.onboarding

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun OnBoardingRoute(navigate: () -> Unit) {
    OnBoardingScreen(navigateToCatName = navigate)
}
