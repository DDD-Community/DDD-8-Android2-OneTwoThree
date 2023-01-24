package com.inseoul.onetwothree.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.inseoul.onboarding.navigation.onBoardingRoute
import com.inseoul.onboarding.navigation.onBoardingScreen
import com.treemiddle.calendar.screen.navigation.calendarRoute
import com.treemiddle.calendar.screen.navigation.onCalendarRoute
import com.treemiddle.catname.navigation.catNameRoute
import com.treemiddle.catname.navigation.onCatNameScreen
import com.treemiddle.setting.navigation.onSettingsScreen

@Composable
fun InseoulNavGraph(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = onBoardingRoute,
        modifier = modifier
    ) {
        onBoardingScreen {
            navController.navigate(catNameRoute)
        }
        onCalendarRoute()
        onSettingsScreen(
            navigateToCatName = {
                navController.navigate(catNameRoute)
            },
            navigateToNotification = {
                // NOTE : 알림 화면으로 이동해야 합니다.
                // navController.navigate("알림화면 만들고 route 연결")
            }
        )
        onCatNameScreen {
            // NOTE : 닉네임을 입력하면 다음 화면으로 이동해야 합니다. (미정)
        }
    }
}

