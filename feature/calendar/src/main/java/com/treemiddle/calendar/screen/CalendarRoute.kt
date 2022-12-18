package com.treemiddle.calendar.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.inseoul.library_calendar.CalendarViewModel

@Composable
fun CalendarRoute(
    modifier: Modifier = Modifier,
    viewModel: CalendarViewModel = hiltViewModel()
) {
    CalendarScreen(viewModel = viewModel)
}
