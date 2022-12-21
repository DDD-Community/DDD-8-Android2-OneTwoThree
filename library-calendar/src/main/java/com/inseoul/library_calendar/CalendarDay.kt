package com.inseoul.library_calendar

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

/*NOTE
디자인 시스템 모듈에 있는 컬러값을 사용하기 위해
해당 모듈에서 core-designsystem 모듈을 추가하면 빌드 에러나오는데 원인을 모르겠음*/
@Composable
fun CalendarDay(
    day: String,
    isActivated: Boolean,
    onDayClicked: () -> Unit
) {
    Text(
        modifier = Modifier
            .size(size = 40.dp)
            .clickable { onDayClicked() },
        text = day,
        color = if (isActivated) {
            Color(0xFF212124)
        } else {
            Color(0xFFD1D3D8)
        },
        textAlign = TextAlign.Center
    )
}
