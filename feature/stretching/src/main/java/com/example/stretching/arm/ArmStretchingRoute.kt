package com.example.stretching.arm

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.stretching.timer.TimerViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ArmStretchingRoute(
    navigateToFinish: () -> Unit,
    navigateToBack: () -> Unit,
    viewModel: TimerViewModel = hiltViewModel()
) {
    ArmStretchingScreen(
        navigateToFinish = navigateToFinish,
        navigateToBack = navigateToBack,
        viewModel = viewModel
    )
}