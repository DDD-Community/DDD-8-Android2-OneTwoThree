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
import com.inseoul.designsystem.toolbar.InseoulToolbar
import com.inseoul.onetwothree.ui.theme.Typography

/*
TODO 애니메이션 전환될 때 화면이 끊기는 문제 해결 필요
 */

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
            Text(text = " 목 올리기 1 번")
            LottieAnimation(com.inseoul.designsystem.R.raw.neckup_2)
        } else if (changeTime2(remainingTime)) {
            Text(text = "목 올리기 2번")
            LottieAnimation(com.inseoul.designsystem.R.raw.neckup_2)
        } else if (changeTime3(remainingTime)) {
            Text(text = "목 올리기 3번")
            LottieAnimation(com.inseoul.designsystem.R.raw.neckup_3)
        }
    }
    if (isTimeFinish(remainingTime)) {
        navigateToFinish()  // 일단 추가
    }
}

@Composable
fun LottieAnimation(res: Int) {
    val composition by rememberLottieComposition(
        spec = LottieCompositionSpec.RawRes(
            res
            //com.inseoul.designsystem.R.raw.shoulder_1
        ),
    )
    val progress by animateLottieCompositionAsState(
        composition = composition,
        iterations = LottieConstants.IterateForever
    )
    com.airbnb.lottie.compose.LottieAnimation(
        composition = composition,
        progress = { progress }
    )
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