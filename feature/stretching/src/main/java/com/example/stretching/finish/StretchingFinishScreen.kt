package com.example.stretching

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavHostController
import com.example.common.Constants
import com.example.stretching.finish.StretchingFinishViewModel
import com.inseoul.designsystem.icon.InseoulIcons
import com.inseoul.designsystem.theme.gray700
import com.inseoul.designsystem.theme.gray900
import com.inseoul.designsystem.toolbar.InseoulToolbar
import com.inseoul.onetwothree.ui.theme.pretendard

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun StretchingFinishScreen(
    navigateToBack: () -> Unit,
    navigateToArm: () -> Unit,
    navigateToNeckdown: () -> Unit,
    navigateToNeckup: () -> Unit,
    navigateToShoulder: () -> Unit,
    navigateToWrist: () -> Unit,
    name: String?,
    stretchingFinishViewModel: StretchingFinishViewModel
    // navigateToMain 메인화면으로 이동하는 nav 구현
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
                Image(
                    modifier = Modifier
                        .height(120.dp)
                        .width(120.dp),
                    alignment = Alignment.Center,
                    imageVector = Icons.Default.Email, contentDescription = null)
                Spacer(modifier = Modifier.height(144.dp))
                Text(text = "스트레칭 완료!", fontFamily = pretendard, fontWeight = FontWeight.Bold, fontSize = 35.sp, color = gray900)

                val cleanRoomList = mutableListOf("캣 타워", "액자", "쓰레기 봉투", "통조림", "과자 봉지")
                val value = cleanRoomList.random()

                Text(text = "${name.toString()} Stretching을 완료해 \n  ${value}가 청소되었어요.", fontFamily = pretendard, fontSize = 24.sp, color = gray700)
                Spacer(modifier = Modifier.height(96.dp))
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    onClick = {
                        // 메인 화면으로 이동!
                    }) {
                    Text(text = "확인")
                }
                Row(
                    modifier = Modifier.padding(horizontal = 16.dp),
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
                            val arr = arrayOf("arm", "neckdown", "neckup", "shoulder", "wrist")
                            val random = arr.random()

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