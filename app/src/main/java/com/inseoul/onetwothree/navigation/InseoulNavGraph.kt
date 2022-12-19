package com.inseoul.onetwothree.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.stretching.StretchingFinishScreen
import com.example.stretching.StretchingScreen

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

    // 임시 테스트 위해 작업 -> will be deleted
    NavHost(navController = navController, startDestination = "route_stretching" ) {
        composable("route_stretching") {
            StretchingScreen(navController = navController)
        }
        composable("route_stretching_finish") {
            StretchingFinishScreen(navController = navController)
        }
    }
}

