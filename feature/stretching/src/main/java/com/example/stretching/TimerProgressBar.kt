package com.example.stretching

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun TimerProgressBar() {
    var progress by remember { mutableStateOf(0.0f) }
    var enabled by remember { mutableStateOf(true) }
    LaunchedEffect(key1 = progress, key2 = enabled) {
        if (progress < 1 && enabled) {
            delay(100L)
            progress += 0.0027F
        }
    }
    LinearProgressIndicator(
        color = Color.Green,
        backgroundColor = Color.Gray,
        progress = progress,
        modifier = Modifier
            .fillMaxWidth()
            .height(68.dp)
    )
}