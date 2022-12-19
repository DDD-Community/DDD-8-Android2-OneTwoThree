package com.example.stretching

import android.annotation.SuppressLint
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.inseoul.designsystem.icon.InseoulIcons

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun StretchingFinishScreen(
    navController: NavHostController = rememberNavController(),
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
        content = { Text(text = "운동 완료") }
    )
}

@Preview
@Composable
fun StretchingFinishScreenPreview() {
    StretchingFinishScreen()
}