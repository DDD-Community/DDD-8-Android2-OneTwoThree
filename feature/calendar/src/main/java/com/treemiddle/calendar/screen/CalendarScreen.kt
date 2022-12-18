package com.treemiddle.calendar.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.inseoul.library_calendar.CalendarDay
import com.inseoul.library_calendar.CalendarToolbar
import com.inseoul.library_calendar.CalendarViewModel
import com.inseoul.library_calendar.CalendarWeek

@Composable
fun CalendarScreen(
    viewModel: CalendarViewModel
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp)
    ) {
        CalendarToolbar(
            title = "캘린더",
            onPreviousClicked = {
                // NOTE : 뒤로가기 클릭
            },
            onNextClicked = {
                // NOTE : 앞으로 가기 클릭
            }
        )
        CalendarWeek()
        LazyVerticalGrid(
            columns = GridCells.Fixed(7)
        ) {
            items(viewModel.getCalendarDays().size) {
                CalendarDay(
                    day = viewModel.getCalendarDays()[it].day,
                    isActivated = viewModel.getCalendarDays()[it].isActivated
                )
            }
        }
    }
}
