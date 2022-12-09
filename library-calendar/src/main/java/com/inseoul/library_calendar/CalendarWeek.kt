package com.inseoul.library_calendar

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CalendarWeek() {
    Row(modifier = Modifier.padding(bottom = 16.dp)) {
        weeks.forEach {
            Text(
                text = it,
                fontSize = 16.sp,
                modifier = Modifier.weight(weight = 1f),
                textAlign = TextAlign.Center,
                color = Color(0xFF868B94)
            )
        }
    }
}

private val weeks: List<String> = listOf("일", "월", "화", "수", "목", "금", "토")
