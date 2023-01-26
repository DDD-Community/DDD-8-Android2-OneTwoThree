package com.example.stretching.wrist

import androidx.compose.runtime.Composable

@Composable
fun WristStretchingRoute(
    navigateToFinish: () -> Unit,
) {
    WristStretchingScreen(
        navigateToFinish = navigateToFinish
    )
}