package com.treemiddle.calendar.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
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
    onOutSideClicked: (Boolean, Int) -> Unit,
    isClickedDay: (Boolean, Int) -> Unit
) {
     val stateList = remember { mutableStateOf(dayStateList) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp),
    ) {
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
        Box(
             contentAlignment = Alignment.Center
        ) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(7),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(stateList.value.size) {
                    val day = stateList.value[it].day
                    val isActivated = stateList.value[it].isActivated
                    val isClicked = stateList.value[it].isClickedDay
                    val stretchCount = stateList.value[it].stretchCount
                    val isShownNextMonth = day.toInt() in 1..7

                    CalendarDay(
                        day = day,
                        isActivated = isActivated,
                        isClicked = isClicked,
                        stretchCount = stretchCount,
                        onDayClicked = { isDayActivated, isDayClicked, day ->
                            if (isDayActivated) {
                                // NOTE : 해당 요일의 데이터를 가져와야 합니다.
                                isClickedDay(isDayClicked, day)
                            } else {
                                onOutSideClicked(isShownNextMonth, day)
                            }
                        }
                    )
                }
            }
        }
    }
}
