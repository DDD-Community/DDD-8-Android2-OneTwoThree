package com.inseoul.library_calendar

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.inseoul.designsystem.theme.gray400
import com.inseoul.designsystem.theme.gray900

@Composable
fun CalendarDay(
    day: String,
    isActivated: Boolean,
    isClicked: Boolean,
    onDayClicked: (Boolean, Boolean, Int) -> Unit,
) {
    val modifier = Modifier
        .size(size = 40.dp)
        .padding(2.dp)
        .clickable {
            onDayClicked(isActivated, isClicked, day.toInt())
        }
    val currentDayModifier = if (isClicked) {
        modifier.border(
            width = 1.5.dp,
            color = gray900,
            shape = CircleShape
        )
    } else {
        modifier
    }

    Text(
        modifier = currentDayModifier,
        text = day,
        color = if (isActivated) {
            gray900
        } else {
            gray400
        },
        textAlign = TextAlign.Center
    )
}
