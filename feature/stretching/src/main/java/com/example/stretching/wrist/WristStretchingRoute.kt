package com.example.stretching.wrist

import androidx.compose.runtime.Composable

@Composable
fun WristStretchingRoute(
    navigateToFinish: () -> Unit,
    navigateToList: () -> Unit
) {
    WristStretchingScreen(
        navigateToFinish = navigateToFinish,
        navigateToList = navigateToList
    )
}