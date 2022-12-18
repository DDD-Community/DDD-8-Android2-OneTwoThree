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
    onNextClicked: () -> Unit,
    onOutSideClicked: (Boolean, Int) -> Unit
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
                val day = dayStateList[it].day
                val isActivated = dayStateList[it].isActivated
                val isShownNextMonth = day.toInt() in 1..7

                CalendarDay(
                    day = day,
                    isActivated = isActivated,
                    onDayClicked = {
                        if (isActivated) {
                            // NOTE : 해당 요일의 데이터를 가져와야 합니다.
                        } else {
                            onOutSideClicked(isShownNextMonth, day.toInt())
                        }
                    }
                )
            }
        }
    }
}
