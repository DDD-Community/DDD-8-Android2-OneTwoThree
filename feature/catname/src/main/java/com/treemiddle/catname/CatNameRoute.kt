package com.treemiddle.catname

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.treemiddle.catname.screen.CatNameScreen

@Composable
fun CatNameRoute(
    modifier: Modifier = Modifier,
    viewModel: CatNameViewModel = hiltViewModel()
) {
    CatNameScreen()
}
