package com.example.stretching.arm

import androidx.compose.runtime.Composable

@Composable
fun ArmStretchingRoute(
    navigateToFinish: () -> Unit
) {
    ArmStretchingScreen(
        navigateToFinish = navigateToFinish
    )
}