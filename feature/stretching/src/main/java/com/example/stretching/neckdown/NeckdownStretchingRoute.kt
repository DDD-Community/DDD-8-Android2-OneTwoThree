package com.example.stretching.neckdown

import androidx.compose.runtime.Composable

@Composable
fun NeckdownStretchingRoute(
    navigateToFinish: () -> Unit,
) {
    NeckdownStretchingScreen(
        navigateToFinish = navigateToFinish
    )
}