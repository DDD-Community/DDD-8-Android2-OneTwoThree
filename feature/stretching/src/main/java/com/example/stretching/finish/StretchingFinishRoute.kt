package com.example.stretching.finish

import androidx.compose.runtime.Composable
import com.example.stretching.StretchingFinishScreen

@Composable
fun StretchingFinishRoute(
    navigateToBack: () -> Unit,
    navigateToArm: () -> Unit,
    navigateToNeckdown: () -> Unit,
    navigateToNeckup: () -> Unit,
    navigateToShoulder: () -> Unit,
    navigateToWrist: () -> Unit,
    name: String?
) {
    StretchingFinishScreen(
        navigateToBack = navigateToBack,
        navigateToArm = navigateToArm,
        navigateToNeckdown = navigateToNeckdown,
        navigateToNeckup = navigateToNeckup,
        navigateToShoulder = navigateToShoulder,
        navigateToWrist = navigateToWrist,
        name = name
    )
}