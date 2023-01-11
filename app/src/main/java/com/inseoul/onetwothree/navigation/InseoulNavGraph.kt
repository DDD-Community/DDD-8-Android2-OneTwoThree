package com.inseoul.onetwothree.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.inseoul.onboarding.navigation.onBoardingRoute
import com.inseoul.onboarding.navigation.onBoardingScreen
import com.treemiddle.calendar.screen.navigation.calendarRoute
import com.treemiddle.calendar.screen.navigation.onCalendarRoute

@Composable
fun InseoulNavGraph(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = onBoardingRoute,
        modifier = modifier
    ) {
        onBoardingScreen {
            // NOTE : 임시로 캘린더 화면으로 이동합니다.
            navController.navigate(calendarRoute)
        }
        onCalendarRoute()
    }
}

