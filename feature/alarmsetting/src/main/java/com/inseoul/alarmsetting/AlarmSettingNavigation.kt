package com.inseoul.alarmsetting

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val alarmSettingRoute = "alarm_setting_route"

fun NavGraphBuilder.alarmSettingScreen(
    navigateToBack: () -> Unit
) {
    composable(route = alarmSettingRoute) {
        AlarmSettingRoute (navigateToBack)
    }
}