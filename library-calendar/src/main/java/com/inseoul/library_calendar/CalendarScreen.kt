package com.inseoul.library_calendar

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CalendarScreen(
    viewModel: CalendarViewModel
) {
    val toolbarTitle = viewModel.getCalendarToolbarTitle()
    val currentCalendar = viewModel.getCalendarDays()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp)
    ) {
        CalendarToolbar(
            title = toolbarTitle,
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
            items(currentCalendar.size) {
                CalendarDay(
                    day = currentCalendar[it].day,
                    isActivated = currentCalendar[it].isActivated
                )
            }
        }
    }
}
