package com.example.stretching

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.example.common.Constants
import com.inseoul.designsystem.icon.InseoulIcons
import com.inseoul.designsystem.theme.gray700
import com.inseoul.designsystem.theme.gray900
import com.inseoul.designsystem.toolbar.InseoulToolbar

// TODO 사물 이미지 리스트로 넣은 후, 랜덤하게 보여주기 (중복x) ~ Math.random

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun StretchingFinishScreen() {
    Scaffold(
        topBar = {
            InseoulToolbar(
                modifier = Modifier,
                title = Constants.EMPTY_STRING,
                backButtonImageResource = InseoulIcons.ArrowBack,
                onImageClicked = {
                    // 뒤로 가기 기능 추가
                }
            )
        },
        content = {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "운동 완료", color = gray900)
                Text(text = "운동 설명", color = gray700)
            }
        }
    )
}