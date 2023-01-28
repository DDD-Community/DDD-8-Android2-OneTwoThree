package com.example.stretching.neckup

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.stretching.timer.TimerViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NeckupStretchingRoute(
    navigateToFinish: () -> Unit,
    viewModel: TimerViewModel = hiltViewModel()
) {
    NeckupStretchingScreen(
        navigateToFinish = navigateToFinish,
        viewModel = viewModel
    )
}