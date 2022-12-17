package com.inseoul.onetwothree.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController

@Composable
fun InseoulNavGraph(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
//    NavHost(
//        navController = navController,
//        startDestination = onBoardingRoute,
//        modifier = modifier
//    ) {
//        onBoardingScreen()
//    }
}

