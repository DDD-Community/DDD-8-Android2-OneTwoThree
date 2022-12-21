package com.treemiddle.calendar.screen

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.inseoul.library_calendar.CalendarViewModel

@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun CalendarRoute(
    modifier: Modifier = Modifier,
    viewModel: CalendarViewModel = hiltViewModel()
) {
    val calendarTitle by viewModel.calendarTitle.collectAsStateWithLifecycle()

     CalendarScreen(
         dayStateList = viewModel.calendarState,
         currentTitle = calendarTitle,
         onBackButtonClicked = {
             // 이전 화면으로 이동해야 합니다.
         },
         onPreviousClicked =  { viewModel.onPreviousClick() },
         onNextClicked = { viewModel.onNextClick() },
         onOutSideClicked = { isShownNextMonth, _ ->
             if (isShownNextMonth) {
                 viewModel.onNextClick()
             } else {
                 viewModel.onPreviousClick()
             }
         },
         isClickedDay = { _, day ->
             viewModel.onDayClick(day = day)
         }
     )
}
