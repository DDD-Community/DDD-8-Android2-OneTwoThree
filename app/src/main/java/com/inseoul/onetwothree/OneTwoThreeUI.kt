package com.inseoul.onetwothree

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.stretching.StretchingScreen
import com.inseoul.onetwothree.navigation.InseoulNavGraph
import com.inseoul.onetwothree.ui.theme.OneTwoThreeTheme

@Composable
fun OneTwoThreeUI() {
    OneTwoThreeTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            InseoulNavGraph()
        }
    }
}

// 테스트를 위해 생성
@Composable
fun ScreenOne(navController: NavHostController) {
    Column {
        Text(text = "첫번째 페이지 입니다.")
        Button(onClick = { navController.navigate("screen_two") }) {
            Text(text = "다음")
        }
    }
}

@Composable
fun ScreenTwo(navController: NavHostController) {
    Column {
        Text(text = "두번째 페이지 입니다")
        Button(onClick = { navController.navigate("screen_one") }) {
            Text(text = "이전")
        }
    }
}

