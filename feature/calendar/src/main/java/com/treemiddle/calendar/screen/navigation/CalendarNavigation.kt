package com.treemiddle.calendar.screen.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.treemiddle.calendar.screen.CalendarRoute

const val calendarRoute = "cat_name_route"

fun NavGraphBuilder.onCalendarRoute() {
    composable(route = calendarRoute) {
        CalendarRoute()
    }
}
