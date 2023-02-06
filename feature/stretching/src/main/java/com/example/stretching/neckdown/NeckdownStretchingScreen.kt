package com.example.stretching.neckdown

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

@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun NeckdownStretchingScreen(
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
        }, content = {
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
        if (changeTimeFirst(remainingTime)) {
            Text(text = "양손을 뒤통수에 댄 뒤 목에 힘을 빼고 천천히 \n 머리를 앞으로 숙여주세요.", color = gray700)
            LottieAnimation(com.inseoul.designsystem.R.raw.neckdown_1)
        } else if (changeTimeSecond(remainingTime)) {
            Text(text = "10초 정도 지그시 눌러주세요.", color = gray700)
            LottieAnimation(com.inseoul.designsystem.R.raw.neckdown_2)
        } else if (changeTimeThird(remainingTime)) {
            Text(text = "깍지 낀 손으로 뒷목을 받쳐준 뒤 목에 힘을 \n 빼고 머리를 천천히 젖혀주세요.", color = gray700)
            LottieAnimation(com.inseoul.designsystem.R.raw.neckdown_3)
        } else {
            Text(text = "목 앞 근육이 늘어남을 느끼며 10초 정도 \n 유지해주세요", color = gray700)
            LottieAnimation(com.inseoul.designsystem.R.raw.neckdown_4)
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

@Composable
fun LottieAnimation(res: Int) {
    val composition by rememberLottieComposition(
        spec = LottieCompositionSpec.RawRes(
            res
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

){
    NeckdownStretchingScreen(
        navigateToFinish = {},
        navigateToBack = {},
        viewModel = viewModel
    )
}