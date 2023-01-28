package com.example.stretching.shoulder

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.R
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.*
import com.example.stretching.ButtonState
import com.example.stretching.TimerModel
import com.example.stretching.TimerScreen
import com.example.stretching.format
import com.example.stretching.timer.TimerViewModel
import com.inseoul.designsystem.theme.bg
import com.inseoul.onetwothree.ui.theme.Typography
import java.time.Duration

// TODO 프리뷰에서는 텍스트가 다 나오지만, 실기기에서는 텍스트가 안 나온다
// TODO 구조 문제 해결 / 코드 정리

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ShoulderStretchingScreen(
    navigateToFinish: () -> Unit,
    // 테스트
    viewModel: TimerViewModel
) {
    val timer by viewModel.timerState.collectAsState(TimerModel())
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = bg
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            StretchingTimer(timer.timeDuration.format(), timer.remainingTime, navigateToFinish)
            Box(
                modifier = Modifier
                    .height(120.dp)
                    .width(120.dp),
            ) {
                LottieAnimation()
            }
        }
    }
}

@Composable
fun LottieAnimation() {
    val composition by rememberLottieComposition(
        spec = LottieCompositionSpec.RawRes(
            com.inseoul.designsystem.R.raw.shoulder_1
        ),
    )
    val progress by animateLottieCompositionAsState(
        composition = composition,
        iterations = LottieConstants.IterateForever
    )
    LottieAnimation(
        composition = composition,
        progress = { progress }
    )
}

@Composable
fun StretchingTimer(
    time: String,
    remainingTime: Long,
    navigateToFinish: () -> Unit,
    ) {
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
        if (changeText1(remainingTime)) {
            Text(text = "1 번")
        } else if (changeText2(remainingTime)) {
            Text(text = "2번")
        }
    }
    if (isTimeFinish(remainingTime)) {
        /*Button(onClick = navigateToFinish) {
            Text(text = "이동")
        }*/
        // TODO 실기기 테스트에서 원활하게 동작x... 문제점 찾기
        navigateToFinish()
    }
}

// 삭제 가능할 듯
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

private fun changeText1(time: Long) = time < 30000L && 15000L<time
private fun changeText2(time: Long) = time < 15000L && 1000L<time
private fun isTimeFinish(time: Long) = time < 1000L

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun TimerPreview() {
    ShoulderStretchingScreen(
        {},
        TimerViewModel())
}