package com.inseoul.library_calendar

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun CalendarToolbar(
    modifier: Modifier = Modifier,
    title: String,
    onPreviousClicked: () -> Unit,
    onNextClicked: () -> Unit
) {
    Row(
        modifier = modifier.padding(top = 16.dp, bottom = 24.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .size(size = 24.dp)
                .clickable { onPreviousClicked() },
            painter = painterResource(
                id = R.drawable.previous
            ),
            contentDescription = "previous",
        )
        Text(
            modifier = Modifier.weight(1f),
            text = title,
            textAlign = TextAlign.Center,
            color = Color(0xFF212124),
            fontWeight = FontWeight.Bold
        )
        Image(
            modifier = Modifier
                .size(size = 24.dp)
                .clickable { onNextClicked() },
            painter = painterResource(
                id = R.drawable.next
            ),
            contentDescription = "next"
        )
    }
}
