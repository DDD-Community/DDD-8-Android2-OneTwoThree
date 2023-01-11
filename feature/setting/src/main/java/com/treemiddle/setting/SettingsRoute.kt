package com.treemiddle.setting

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.treemiddle.setting.screen.SettingsScreen

@Composable
fun SettingsRoute(
    navigateToCatName: () -> Unit,
    navigateToNotification: () -> Unit,
    viewModel: SettingsViewModel = hiltViewModel()
) {
    SettingsScreen(
        navigateToCatName = navigateToCatName,
        navigateToNotification = navigateToNotification
    )
}
