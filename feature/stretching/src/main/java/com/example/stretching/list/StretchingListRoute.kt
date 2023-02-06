package com.example.stretching.list

import androidx.compose.runtime.Composable
import com.example.stretching.StretchingListScreen

@Composable
fun StretchingListRoute(
    navigateToBack: () -> Unit,
    navigateToArm: () -> Unit,
    navigateToNeckdown: () -> Unit,
    navigateToNeckup: () -> Unit,
    navigateToShoulder: () -> Unit,
    navigateToWrist: () -> Unit
) {
    StretchingListScreen(
        navigateToBack = navigateToBack,
        navigateToArm = navigateToArm,
        navigateToNeckdown= navigateToNeckdown,
        navigateToNeckup = navigateToNeckup,
        navigateToShoulder = navigateToShoulder,
        navigateToWrist = navigateToWrist
    )
}