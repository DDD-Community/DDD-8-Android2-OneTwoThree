package com.inseoul.onborading

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.inseoul.onborading.screen.IntroScreen
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoardingScreen(modifier: Modifier = Modifier) {
    val pagerState = rememberPagerState()
    val scope = rememberCoroutineScope()

    Surface(modifier.fillMaxSize()) {
        HorizontalPager(count = 3, state = pagerState) { page ->
            when (page) {
                0 -> {
                    IntroScreen(
                        title = "첫 번째 타이틀",
                        description = "테스트11111",
                        currentPagerIndex = 0,
                        totalPagerCount = 3,
                        onButtonClicked = {
                            scope.launch {
                                pagerState.animateScrollToPage(1)
                            }
                        }
                    )
                }
                1 -> {
                    IntroScreen(
                        title = "타 이 틀 두 번 째 ",
                        description = "one two three",
                        currentPagerIndex = 1,
                        totalPagerCount = 3,
                        onButtonClicked = {
                            scope.launch {
                                pagerState.animateScrollToPage(page + 1)
                            }
                        }
                    )
                }
                else -> {
                    TestScreen()
                }
            }
        }
    }
}


@Composable
fun TestScreen() {
    Column {
        Image(imageVector = Icons.Default.AccountBox, contentDescription = null)
        Image(imageVector = Icons.Default.AccountCircle, contentDescription = null)
        Image(imageVector = Icons.Default.Add, contentDescription = null)
        Image(imageVector = Icons.Default.ArrowBack, contentDescription = null)
    }
}
