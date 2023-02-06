package com.example.stretching.arm

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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
fun ArmStretchingScreen(
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
                title = "팔 운동",
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
        // TODO 함수명 변경 & 시간 조절
        if (changeTimeFirst(remainingTime)) {
            Text(text = "어깨 높이에서 왼쪽 팔을 편 다음 반대편 팔을 \n 이용해 몸통 방향으로 끌어당겨줘요.", color = gray700)
            LottieAnimation(com.inseoul.designsystem.R.raw.arm_1)
        } else if (changeTimeSecond(remainingTime)) {
            Text(text = "얼굴은 편 팔의 반대 방향으로 돌리고, \n 10초 정도 지그시 당겨주세요.", color = gray700)
            LottieAnimation(com.inseoul.designsystem.R.raw.arm_2)
        } else if (changeTimeThird(remainingTime)) {
            Text(text = "어깨 높이에서 오른쪽 팔을 편 다음 반대편 팔을 \n 이용해 몸통 방향으로 끌어당겨줘요.", color = gray700)
            LottieAnimation(com.inseoul.designsystem.R.raw.arm_3)
        } else {
            Text(text = "얼굴은 편 팔의 반대 방향으로 돌리고, \n 10초 정도 지그시 당겨주세요.", color = gray700)
            LottieAnimation(com.inseoul.designsystem.R.raw.arm_4)
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