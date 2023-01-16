package com.treemiddle.setting.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.treemiddle.setting.SettingsRoute

const val settingsRoute = "settings_route"

fun NavGraphBuilder.onSettingsScreen(
    navigateToCatName: () -> Unit,
    navigateToNotification: () -> Unit
) {
    composable(route = settingsRoute) {
        SettingsRoute(navigateToCatName, navigateToNotification)
    }
}
