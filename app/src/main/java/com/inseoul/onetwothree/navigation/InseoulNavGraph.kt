package com.inseoul.onetwothree.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.inseoul.onetwothree.ScreenOne
import com.inseoul.onetwothree.ScreenTwo

@Composable
fun InseoulNavGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "screen_one") {
        composable("screen_one") { ScreenOne(navController) }
        composable("screen_two") { ScreenTwo(navController) }
    }
}

