package com.example.stretching

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.common.Constants
import com.example.stretching.timer.TimerViewModel
import com.inseoul.onetwothree.ui.theme.Typography
import com.inseoul.onetwothree.ui.theme.pretendard
import java.time.Duration

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TimerScreen(viewModel: TimerViewModel) {
    val timer by viewModel.timerState.collectAsState(TimerModel())
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        StretchingTimer(timer.timeDuration.format(), timer.remainingTime)
        Spacer(modifier = Modifier.height(36.dp))
        TimerButton(viewModel)
    }
}

@Composable
fun StretchingTimer(time: String, remainingTime: Long) {
    Column {
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
                color = Color.Black,
                style = Typography.h1
            )
        }
        Text(text = "시간에 따른 텍스트 변화 테스트")
        if (changeTime1(remainingTime)) {
            Text(text = "1 번")
        } else if (changeTime2(remainingTime)) {
            Text(text = "2번")
        } else if (changeTime3(remainingTime)) {
            Text(text = "3번")
        }
        


    }
    if (isTimeFinish(remainingTime)) {
        // 화면 이동
    }
    /*Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = time,
            fontSize = 60.sp,
            color = Color.Black,
            style = Typography.h1
        )
    }
    if (isTimeFinish(remainingTime)) {
        // 화면 이동
    }*/
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TimerButton(timerState: TimerViewModel) {
    val toggle by timerState.timerState.collectAsState()
    var text = Constants.EMPTY_STRING
    var color = Color.Gray
    var textColor: Color = Color.Black

    when (toggle.toggle) {
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
        else -> {

        }
    }

    Box(modifier = Modifier
        .clickable { timerState.selectTimerState() }
        .width(135.5.dp)
        .height(56.dp)
        .background(color)
        .fillMaxWidth()
    ) {
        Text(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(8.dp),
            text = text,
            color = textColor,
            fontWeight = FontWeight.Bold,
            fontFamily = pretendard,
            fontSize = 21.sp
        )
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

private fun isTimeFinish(time: Long) = time < 1000L
private fun changeTime1(time: Long) = time in 20001..24999
private fun changeTime2(time: Long) = time < 20000L && 15000L<time
private fun changeTime3(time: Long) = time < 15000L

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun TimerPreview() {
    TimerScreen(TimerViewModel())
}