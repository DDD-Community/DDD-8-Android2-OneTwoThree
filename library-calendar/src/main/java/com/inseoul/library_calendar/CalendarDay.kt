package com.inseoul.library_calendar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.inseoul.designsystem.theme.Green300
import com.inseoul.designsystem.theme.bg
import com.inseoul.designsystem.theme.gray400
import com.inseoul.designsystem.theme.gray900

@Composable
fun CalendarDay(
    modifier: Modifier = Modifier,
    day: String,
    isActivated: Boolean,
    isClicked: Boolean,
    stretchCount: Int,
    isFirstInitialized: Boolean,
    onDayClicked: (Boolean, Boolean, Int) -> Unit,
) {
    val stretchImage = if (stretchCount >= 5) {
        CalendarIcons.stretchTotalCountMoreFive
    } else {
        CalendarIcons.stretchTotalCountUnderFive
    }
    val dayTextColor = if (isActivated) {
        if (isFirstInitialized) {
            Green300
        } else {
            gray900
        }
    } else {
        gray400
    }
    val fontWeight = if (isActivated) {
        if (isClicked || isFirstInitialized) {
            FontWeight.Bold
        } else {
            null
        }
    } else {
        null
    }
    val defaultModifier = modifier
        .height(56.dp)
        .clickable { onDayClicked(isActivated, isClicked, day.toInt()) }
    val columnModifier = if (isClicked) {
        defaultModifier.background(
            color = bg,
            shape = RoundedCornerShape(
                topStart = 100.dp,
                topEnd = 100.dp,
                bottomEnd = 100.dp,
                bottomStart = 100.dp
            )
        )
    } else {
        defaultModifier
    }

    Column(
        modifier = columnModifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = day,
            color = dayTextColor,
            fontWeight = fontWeight,
            textAlign = TextAlign.Center
        )

        if (stretchCount != 0 && isActivated) {
            Image(
                modifier = Modifier.size(12.dp),
                painter = painterResource(id = stretchImage),
                contentDescription = null
            )
        }
    }
}
