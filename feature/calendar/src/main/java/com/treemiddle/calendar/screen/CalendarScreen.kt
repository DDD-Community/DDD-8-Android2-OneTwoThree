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
        // NOTE : 툴바 속성 수정이 필요합니다.
        InseoulToolbar(
            modifier = Modifier,
            title = "캘린더",
            backButtonImageResource = ArrowBack,
            onImageClicked = {
                // NOTE : 툴바 뒤로가기
            }
        )
        CalendarToolbar(
            title = "2022년 12월",
            onPreviousClicked = {
                // NOTE : 이전 달로 이동해야 합니다.
            },
            onNextClicked = {
                // NOTE : 다음 달로 이동해야 합니다.
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
