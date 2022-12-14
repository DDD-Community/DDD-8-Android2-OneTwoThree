package com.example.stretching

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.example.common.Constants
import com.inseoul.designsystem.icon.InseoulIcons
import com.inseoul.designsystem.toolbar.InseoulToolbar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun StretchingFinishScreen(
    navController: NavHostController,
) {
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
        content = { Text(text = "운동 완료") }
    )
}