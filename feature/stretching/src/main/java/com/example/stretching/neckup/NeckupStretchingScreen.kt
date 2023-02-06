package com.example.stretching.neckup

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
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.stretching.*
import com.example.stretching.timer.TimerViewModel
import com.inseoul.designsystem.icon.InseoulIcons
import com.inseoul.designsystem.theme.bg
import com.inseoul.designsystem.theme.gray700
import com.inseoul.designsystem.toolbar.InseoulToolbar
import com.inseoul.onetwothree.ui.theme.Typography

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NeckupStretchingScreen(
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
                title = "목 업 운동",
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
                    Text(text = "목 올리기 스트레칭 화면")
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
        if (changeTimeFirst(remainingTime)) {
            Text(text = "왼쪽으로 고개를 갸우뚱 숙인 후 왼손으로 \n 머리를 가볍게 눌러주세요.", color = gray700)
            LottieAnimation(com.inseoul.designsystem.R.raw.neckup_2)
        } else if (changeTimeSecond(remainingTime)) {
            Text(text = "반대편 어깨가 따라 올라가지 않도록 \n 주의하며 약 10초간 목 근육을 늘려주세요.", color = gray700)
            LottieAnimation(com.inseoul.designsystem.R.raw.neckup_2)
        } else if (changeTimeThird(remainingTime)) {
            Text(text = "오른쪽으로 고개를 갸웅뚱 숙인 후 오른손으로 \n 머리를 가볍게 눌러주세요.", color = gray700)
            LottieAnimation(com.inseoul.designsystem.R.raw.neckup_3)
        } else {
            Text(text = "반대편 어깨가 따라 올라가지 않도록 \n 주의하며 약 10초간 목 근육을 늘려주세요", color = gray700)
            LottieAnimation(com.inseoul.designsystem.R.raw.neckup_4)
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
        navigateToFinish()  // 일단 추가
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun PreviewTest(
    viewModel: TimerViewModel = hiltViewModel()
) {
    NeckupStretchingScreen(
        navigateToFinish = {},
        navigateToBack = {},
        viewModel = viewModel
    )
}