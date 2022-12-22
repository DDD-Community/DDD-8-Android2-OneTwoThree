package com.inseoul.onetwothree.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.treemiddle.calendar.screen.navigation.calendarRoute
import com.treemiddle.calendar.screen.navigation.onCalendarRoute

@Composable
fun InseoulNavGraph(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = calendarRoute,
        modifier = modifier
    ) {
        onCalendarRoute()
    }
}

