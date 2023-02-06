package com.inseoul.alarmsetting

import androidx.compose.runtime.Composable

@Composable
fun AlarmSettingRoute(
    navigateToBack: () -> Unit
) {
 AlarmSettingScreen(navigateToBack = navigateToBack)
}