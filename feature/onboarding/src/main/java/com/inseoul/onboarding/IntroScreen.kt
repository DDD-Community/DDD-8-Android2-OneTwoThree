package com.inseoul.onboarding

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.inseoul.designsystem.button.H56Button
import com.inseoul.designsystem.theme.*

@Composable
fun IntroScreen(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    currentPagerIndex: Int,
    totalPagerCount: Int,
    onButtonClicked: () -> Unit
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
            currentPagerIndex = currentPagerIndex,
            onButtonClicked = onButtonClicked
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
            textAlign = TextAlign.Center,
            color = gray700
        )
    }
}

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
            Canvas(modifier = modifier
                .padding(horizontal = 5.dp)
                .size(10.dp)) {
                drawCircle(
                    color = if (i == currentPagerIndex) {
                        Green300
                    } else {
                        gray300
                    }
                )
            }
        }
    }
}

@Composable
fun IntroButton(
    modifier: Modifier = Modifier,
    currentPagerIndex: Int,
    onButtonClicked: () -> Unit
) {
    H56Button(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, bottom = 24.dp),
        title = if (currentPagerIndex == 0) "다음" else "고양이 이름 지어주기",
        cornerRadius = 16,
        backgroundColor = gray900,
        textColor = gray00,
        onClicked = onButtonClicked
    )
}
