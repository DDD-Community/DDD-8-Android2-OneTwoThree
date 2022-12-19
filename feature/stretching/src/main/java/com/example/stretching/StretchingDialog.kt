package com.example.stretching

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog

@Composable
fun TestScreen() {
    val showDialog = remember { mutableStateOf(false) }
    if (showDialog.value)
        StretchingDialog(setShowDialog = { showDialog.value = it })

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Button(onClick = { showDialog.value = true }) {
            Text(text = "Dialog")
        }
    }
}

@Composable
fun StretchingDialog(
    setShowDialog: (Boolean) -> Unit,
) {
    Dialog(onDismissRequest = { setShowDialog(false) }) {
        Surface(
            shape = RoundedCornerShape(16.dp),
            color = Color.White
        ) {
            Box(
                contentAlignment = Alignment.Center
            ) {
                Column(modifier = Modifier.padding(20.dp)) {
                    Text(
                        text = "이대로 나가면 기록이 저장되지 않아요.",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(text = "그래도 나갈까요?", fontSize = 16.sp)
                    Spacer(modifier = Modifier.height(24.dp))

                    Row(modifier = Modifier.fillMaxWidth()) {
                        Button(
                            modifier = Modifier
                                .weight(1f)
                                .padding(end = 4.dp),
                            onClick = { setShowDialog(false) },
                            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
                        ) {
                            Text(text = "이어하기", color = Color.Black)
                        }
                        Button(
                            onClick = {
                                // 뒤로 가기 구현(nav)
                            },
                            modifier = Modifier
                                .weight(1f)
                                .padding(start = 4.dp),
                            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)
                        ) {
                            Text(text = "나가기", color = Color.White)
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewTest() {
    TestScreen()
}