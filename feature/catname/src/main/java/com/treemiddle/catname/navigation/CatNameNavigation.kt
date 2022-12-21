package com.treemiddle.catname.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.treemiddle.catname.CatNameRoute

const val catNameRoute = "cat_name_route"

fun NavGraphBuilder.onCatNameScreen() {
    composable(route = catNameRoute) {
        CatNameRoute()
    }
}
