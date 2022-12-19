package com.example.stretching

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.inseoul.designsystem.icon.InseoulIcons

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun StretchingScreen(
    navController: NavHostController,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "") },
                backgroundColor = Color.White,
                navigationIcon = {
                    val showDialog = remember { mutableStateOf(false) }
                    if (showDialog.value)
                        StretchingDialog(
                            setShowDialog = { showDialog.value = it },
                            navController = navController
                        )
                    IconButton(onClick = { showDialog.value = true }) {
                        Icon(
                            painter = painterResource(id = InseoulIcons.ArrowBack),
                            contentDescription = "back"
                        )
                    }
                }
            )
        },
        content = {
            Column {
                StretchingUI()
                // todo 이미지 추가
                Timer()
                TimerProgressBar()
            }
        }
    )
}

@Composable
fun StretchingUI() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "스트레칭 이름")
        Text(text = "머리를 오른쪽으로 잡아당기며 약 10초간 유지해주세용")
    }
}


@Preview
@Composable
fun StretchingPreview() {
    val navController = rememberNavController()
    StretchingScreen(navController)
}