package com.inseoul.onborading.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun IntroScreen(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    currentPagerIndex: Int,
    totalPagerCount: Int
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            IntroImage()
            IntroInformation(
                title = title,
                description = description
            )
            IntroDot(
                currentPagerIndex = currentPagerIndex,
                totalPagerCount = totalPagerCount
            )
        }

        IntroButton(
            modifier = Modifier
                .weight(1f, false),
            currentPagerIndex = currentPagerIndex
        )
    }
}

@Composable
fun IntroImage(modifier: Modifier = Modifier) {
    Image(
        modifier = modifier.size(360.dp),
        imageVector = Icons.Default.AccountBox,
        contentDescription = null
    )
}

@Composable
fun IntroInformation(
    modifier: Modifier = Modifier,
    title: String,
    description: String
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 36.dp, start = 16.dp, end = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = Color.Black,
            textAlign = TextAlign.Center
        )
        Text(
            text = description,
            fontSize = 18.sp,
            textAlign = TextAlign.Center
        )
    }
}

// NOTE : 임시로 Image로 해놨습니다.
@Composable
fun IntroDot(
    modifier: Modifier = Modifier,
    currentPagerIndex: Int,
    totalPagerCount: Int
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 32.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        for (i in 0 until totalPagerCount) {
            Image(
                imageVector = if (i == currentPagerIndex) {
                    Icons.Default.AccountCircle
                } else {
                    Icons.Default.Add
                },
                contentDescription = "dot: $i"
            )
        }
    }
}

// NOTE : 디자인시스템 버튼을 사용해야 합니다.
@Composable
fun IntroButton(
    modifier: Modifier = Modifier,
    currentPagerIndex: Int
) {
    Button(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, bottom = 24.dp),
        onClick = { }
    ) {
        Text(text = if (currentPagerIndex == 0) "다음" else "고양이 이름 지어주기")
    }
}
