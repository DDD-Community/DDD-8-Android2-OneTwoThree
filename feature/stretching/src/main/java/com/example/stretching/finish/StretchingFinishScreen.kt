package com.example.stretching

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.common.Constants
import com.inseoul.designsystem.icon.InseoulIcons
import com.inseoul.designsystem.theme.gray700
import com.inseoul.designsystem.theme.gray900
import com.inseoul.designsystem.toolbar.InseoulToolbar

// TODO 사물 이미지 리스트로 넣은 후, 랜덤하게 보여주기 (중복x) ~ Math.random

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun StretchingFinishScreen(
    navigateToBack: () -> Unit,
    navigateToArm: () -> Unit,
    navigateToNeckdown: () -> Unit,
    navigateToNeckup: () -> Unit,
    navigateToShoulder: () -> Unit,
    navigateToWrist: () -> Unit,
    // TODO navigateToMain 메인화면으로 이동하는 nav 구현
) {
    Scaffold(
        topBar = {
            InseoulToolbar(
                modifier = Modifier,
                title = Constants.EMPTY_STRING,
                backButtonImageResource = InseoulIcons.ArrowBack,
                onImageClicked = navigateToBack

            )
        },
        content = {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "스트레칭 완료!", color = gray900)
                Text(text = "x를 완료해 \n y가 청소되었어요.", color = gray700)
                Spacer(modifier = Modifier.height(96.dp))
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "확인")
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Button(
                        modifier = Modifier.weight(1f),
                        onClick = navigateToNeckdown,
                    ) {
                        Text(text = "한 번 더")
                    }
                    Button(
                        modifier = Modifier.weight(1f),
                        onClick = {
                            // TODO 랜덤으로 스트레칭 고르는 함수 만들기
                            val arr = arrayOf("arm", "neckdown", "neckup", "shoulder", "wrist")
                            val random = arr.random()

                            // 코드가 너무 길어지능뎅... ㅠ
                            if (random == "arm") {
                                navigateToArm()
                            } else if (random == "neckdown") {
                                navigateToNeckdown()
                            } else if (random == "neckup") {
                                navigateToNeckup()
                            } else if (random == "shoulder") {
                                navigateToShoulder()
                            } else {
                                navigateToWrist()
                            }
                        }
                    ) {
                        Text(text = "랜덤으로 계속")
                    }
                }
            }
        }
    )


}