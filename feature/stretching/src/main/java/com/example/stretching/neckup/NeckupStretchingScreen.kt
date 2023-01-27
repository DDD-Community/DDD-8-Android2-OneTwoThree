package com.example.stretching.neckup

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.inseoul.designsystem.theme.bg

@Composable
fun NeckupStretchingScreen(
    navigateToFinish: () -> Unit,
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = bg
    ) {
        Column {
            Text(text = "목 올리기 스트레칭 화면")
        }
    }
}