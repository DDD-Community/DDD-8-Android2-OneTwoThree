package com.inseoul.onetwothree.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.inseoul.onborading.navigation.onBoardingRoute
import com.inseoul.onborading.navigation.onBoardingScreen

@Composable
fun InseoulNavGraph(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = onBoardingRoute,
        modifier = modifier
    ) {
        onBoardingScreen()
    }
}

