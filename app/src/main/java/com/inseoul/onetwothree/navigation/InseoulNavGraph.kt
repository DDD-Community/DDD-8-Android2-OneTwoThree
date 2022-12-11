package com.inseoul.onetwothree.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun InseoulNavGraph(
    modifier: Modifier,
) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "screen_one") {
        composable("users_list") { ScreenOne(navController) }
        composable("user_detail") { ScreenTwo(navController) }
    }
}
// 테스트를 위해 생성
@Composable
fun ScreenOne(navController: NavHostController) {
    Column {
        Text(text = "Hello!")
        Button(onClick = { navController.navigate("screen_one") }) {

        }
    }
}

@Composable
fun ScreenTwo(navController: NavHostController) {
    Column {
        Text(text = "detail screnn")
        Button(onClick = { navController.navigate("screen_two") }) {

        }
    }
}