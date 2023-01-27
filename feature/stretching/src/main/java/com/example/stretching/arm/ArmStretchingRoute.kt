package com.example.stretching.arm

import androidx.compose.runtime.Composable

@Composable
fun ArmStretchingRoute(
    navigateToFinish: () -> Unit,
    navigateToList: () -> Unit
) {
    ArmStretchingScreen(
        navigateToFinish = navigateToFinish,
        navigateToList = navigateToList
    )
}