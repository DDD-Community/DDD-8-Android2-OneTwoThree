package com.inseoul.onborading

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun OnBoardingRoute(
    modifier: Modifier = Modifier,
    viewModel: OnBoardingViewModel = hiltViewModel()
) {
    Column {
        Text(text = "dddd")
        Text(text = "ddddasdfasdfasdfasdf")
    }
}
