package com.example.stretching

import android.os.Build
import android.os.CountDownTimer
import androidx.annotation.RequiresApi
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.common.Constants
import java.time.Duration

@Composable
fun Timer(
    navController: NavHostController

) {
    var millisInFutire: Long = 60 * 1000
    var timeData by remember { mutableStateOf(millisInFutire) }
    val countDownTimer = object : CountDownTimer(millisInFutire, 1000) {
        override fun onTick(millisUntilFinished: Long) {
            timeData = (millisUntilFinished / 1000)
        }

        // 측정이 끝난 경우(지정된 시간이 모두 지나감)
        override fun onFinish() {
            // todo 화면 이동 및 데이터 전송
            //navController.navigate("route_stretching_finish")
        }
    }
    DisposableEffect(key1 = "key") {
        countDownTimer.start()
        onDispose {
            countDownTimer.cancel()
        }
    }
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(text = "0".pad(), modifier = Modifier, style = MaterialTheme.typography.h1)
        Text(text = ":", modifier = Modifier, style = MaterialTheme.typography.h1)
        Text(
            text = timeData.toString().pad(),
            modifier = Modifier,
            style = MaterialTheme.typography.h1
        )
    }
}

fun String.pad(): String {
    return this.padStart(2, '0')
}

// 하단 새로운 코드 추가

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TimerScreen(viewModel: TimerViewModel) {
    val timer by viewModel.viewState.collectAsState(TimerModel())
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
            StretchingTimer(timer.timeDuration.format(), timer.remainingTime)
            TimerButton(viewModel)

    }
}

@RequiresApi(Build.VERSION_CODES.O)
fun Duration.format(): String {
    val seconds = kotlin.math.abs(seconds)
    val value = String.format(
        "%02d:%02d",
        seconds % 3600 / 60,
        seconds % 60
    )
    return value
}

@Composable
fun StretchingTimer(time: String, remainingTime: Long) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = time,
            fontSize = 60.sp,
            color = Color.Black
        )
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TimerButton(timerState: TimerViewModel) {
    ButtonLayout(timerState)
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ButtonLayout(timerState: TimerViewModel) {
    val toggle by timerState.viewState.collectAsState()
    var text = Constants.EMPTY_STRING
    var color = Color.White
    var textColor: Color = Color.Black

    when (toggle.toggle) {
        /*ButtonState.START -> {
            text = "시작"
            color = Color.White
            textColor = Color.Black
        }*/
        ButtonState.PAUSE -> {
            text = "잠시 멈춤"
            color = Color.White
            textColor = Color.Black
        }
        ButtonState.RESUME -> {
            text = "다시 시작"
            color = Color.Black
            textColor = Color.White
        }
    }
    Box(modifier = Modifier
        .clickable { timerState.buttonSelection() }
        .padding(10.dp)
        .size(80.dp)
        .background(color)
        .fillMaxWidth()
    ) {
        Text(
            text = text, color = textColor, modifier = Modifier
                .align(Alignment.Center)
                .padding(8.dp)
        )
    }
}


@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun TimerPreview() {
    //Timer()
    TimerScreen(TimerViewModel())
}