package com.example.stretching.wrist

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
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.stretching.*
import com.example.stretching.neckup.LottieAnimation
import com.example.stretching.timer.TimerViewModel
import com.inseoul.designsystem.R
import com.inseoul.designsystem.icon.InseoulIcons
import com.inseoul.designsystem.theme.bg
import com.inseoul.designsystem.theme.gray700
import com.inseoul.designsystem.toolbar.InseoulToolbar
import com.inseoul.onetwothree.ui.theme.Typography

@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun WristStretchingScreen(
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
                title = "손목 운동 운동",
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
fun StretchingTimer(time: String, remainingTime: Long, navigateToFinish: () -> Unit,) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (changeTime1(remainingTime)) {
            Text(text = "팔을 죽 뻗어 손바닥을 몸 안쪽으로 향하게 \n 한 후 반대쪽 손으로 잡고 당겨요.", color = gray700)
            LottieAnimation(R.raw.wrist_1)
        } else if (changeTime2(remainingTime)) {
            Text(text = "10초 정도 지그시 눌러주세요.", color = gray700)
            LottieAnimation(R.raw.wrist_2)
        } else if (changeTime3(remainingTime)) {
            Text(text = "팔을 쭉 뻗어 손바닥을 몸 바깥쪽으로 \n 향하게 한 후 반대쪽 손으로 잡고 당겨요.", color = gray700)
            LottieAnimation(R.raw.wrist_3)
        } else {
            Text(text = "10초 정도 지그시 눌러주세요.", color = gray700)
            LottieAnimation(R.raw.wrist_4)
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

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun PreviewTest(
    viewModel: TimerViewModel = hiltViewModel()
) {
    WristStretchingScreen(
        navigateToFinish = {},
        navigateToBack = {},
        viewModel = viewModel
    )
}