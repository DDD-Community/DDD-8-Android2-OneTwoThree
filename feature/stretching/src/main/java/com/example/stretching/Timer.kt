package com.example.stretching

import android.os.CountDownTimer
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Timer() {
    var millisInFutire: Long = 60 * 1000
    var timeData by remember { mutableStateOf(millisInFutire) }
    val countDownTimer = object : CountDownTimer(millisInFutire, 1000) {
        override fun onTick(millisUntilFinished: Long) {
            timeData = (millisUntilFinished / 1000)
        }

        // 측정이 끝난 경우(지정된 시간이 모두 지나감)
        override fun onFinish() {
            // todo 화면 이동 및 데이터 전송
        }
    }
    DisposableEffect(key1 = "key") {
        countDownTimer.start()
        onDispose {
            countDownTimer.cancel()
        }
    }
    Row(modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center) {
        Text(text = "0".pad(), modifier = Modifier, style = MaterialTheme.typography.h1)
        Text(text = ":", modifier = Modifier, style = MaterialTheme.typography.h1)
        Text(text = timeData.toString().pad(), modifier = Modifier, style = MaterialTheme.typography.h1)
    }
}

fun String.pad(): String {
    return this.padStart(2,'0')
}


@Preview
@Composable
fun TimerPreview() {
    Timer()
}