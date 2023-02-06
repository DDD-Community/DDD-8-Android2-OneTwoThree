package com.example.stretching.shoulder

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.*
import com.example.stretching.*
import com.example.stretching.format
import com.example.stretching.timer.TimerViewModel
import com.inseoul.designsystem.icon.InseoulIcons
import com.inseoul.designsystem.theme.bg
import com.inseoul.designsystem.theme.gray700
import com.inseoul.designsystem.toolbar.InseoulToolbar
import com.inseoul.onetwothree.ui.theme.Typography
import java.time.Duration

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ShoulderStretchingScreen(
    navigateToFinish: () -> Unit,
    navigateToBack: () -> Unit,
    viewModel: TimerViewModel
) {
    val timer by viewModel.timerState.collectAsState(TimerModel())
    val showDialog = remember { mutableStateOf(false) }
    if (showDialog.value)
        StretchingDialog(
            setShowDialog = { showDialog.value = it },
            navigateToBack = navigateToBack
        )

    Scaffold(
        topBar = {
            InseoulToolbar(
                modifier = Modifier,
                title = "어깨 돌리기",
                backButtonImageResource = InseoulIcons.ArrowBack,
                onImageClicked = {
                    showDialog.value = true
                }
            )
        },
        content = {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = bg
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    StretchingTimer(
                        timer.timeDuration.format(),
                        timer.remainingTime,
                        navigateToFinish
                    )
                    TimerButton(viewModel)
                }
            }
        }
    )
}

@Composable
fun StretchingTimer(
    time: String,
    remainingTime: Long,
    navigateToFinish: () -> Unit,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        LottieAnimation(com.inseoul.designsystem.R.raw.shoulder_1)
        if (changeShoulderTextFirst(remainingTime)) {
            Text(text = "양팔을 아래로 뻗고 어깨로 앞에서 뒤로 \n 원을 그리듯 돌려주세요", color = gray700)
        } else if (changeShoulderTextSecond(remainingTime)) {
            Text(text = "너무 빠르게 움직이지 않도록 주의하며 \n 30초간 반복해 주세요", color = gray700)
        }
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
    }
    if (isTimeFinish(remainingTime)) {
        navigateToFinish()
    }
}

private fun changeShoulderTextFirst(time: Long) = time < 30000L && 15000L < time
private fun changeShoulderTextSecond(time: Long) = time < 15000L && 1000L < time
private fun isTimeFinish(time: Long) = time < 1000L

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun TimerPreview() {
    ShoulderStretchingScreen(
        {},
        {},
        TimerViewModel()
    )
}