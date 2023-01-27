package com.example.stretching.neckup

import androidx.compose.runtime.Composable

@Composable
fun NeckupStretchingRoute(
    navigateToFinish: () -> Unit,
) {
    NeckupStretchingScreen(
        navigateToFinish = navigateToFinish,
    )
}