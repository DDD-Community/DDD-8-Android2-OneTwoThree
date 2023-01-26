package com.example.stretching.shoulder

import androidx.compose.runtime.Composable

@Composable
fun ShoulderStretchingRoute(
    navigateToFinish: () -> Unit,
) {
    ShoulderStretchingScreen(
        navigateToFinish = navigateToFinish
    )
}