package com.treemiddle.calendar.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.inseoul.designsystem.icon.InseoulIcons.ArrowBack
import com.inseoul.designsystem.toolbar.InseoulToolbar
import com.inseoul.library_calendar.CalendarDay
import com.inseoul.library_calendar.CalendarToolbar
import com.inseoul.library_calendar.CalendarWeek
import com.inseoul.library_calendar.DayState

@Composable
fun CalendarScreen(
    dayStateList: List<DayState>,
    currentTitle: String,
    onBackButtonClicked: () -> Unit,
    onPreviousClicked: () -> Unit,
    onNextClicked: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp)
    ) {
        // NOTE : 툴바 속성 수정이 필요합니다.
        InseoulToolbar(
            modifier = Modifier,
            title = "캘린더",
            backButtonImageResource = ArrowBack,
            onImageClicked = { onBackButtonClicked() }
        )
        CalendarToolbar(
            title = currentTitle,
            onPreviousClicked = { onPreviousClicked() },
            onNextClicked = { onNextClicked() }
        )
        CalendarWeek()
        LazyVerticalGrid(
            columns = GridCells.Fixed(7)
        ) {
            items(dayStateList.size) {
                CalendarDay(
                    day = dayStateList[it].day,
                    isActivated = dayStateList[it].isActivated
                )
            }
        }
    }
}
