package com.example.stretching.arm

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.inseoul.designsystem.theme.bg

@Composable
fun ArmStretchingScreen(
    navigateToFinish: () -> Unit,
    navigateToList: () -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = bg
    ) {
        Column {
            Text(text = "팔 스트레칭 화면")
        }
    }
}