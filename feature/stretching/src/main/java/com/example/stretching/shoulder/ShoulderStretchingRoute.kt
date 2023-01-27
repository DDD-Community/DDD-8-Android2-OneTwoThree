package com.example.stretching.shoulder

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.stretching.timer.TimerViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ShoulderStretchingRoute(
    navigateToFinish: () -> Unit,
    viewModel: TimerViewModel = hiltViewModel()
) {
    ShoulderStretchingScreen(
        navigateToFinish = navigateToFinish,
        viewModel = viewModel
    )
}