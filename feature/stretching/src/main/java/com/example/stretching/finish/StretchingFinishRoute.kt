package com.example.stretching.finish

import androidx.compose.runtime.Composable
import com.example.stretching.StretchingFinishScreen

@Composable
fun StretchingFinishRoute(
    navigateToBack: () -> Unit,
) {
    StretchingFinishScreen(
        navigateToBack = navigateToBack
    )
}