package com.inseoul.onboarding

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
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoardingScreen(
    navigateToCatName: () -> Unit
) {
    val pagerState = rememberPagerState()
    val scope = rememberCoroutineScope()

    Surface(modifier = Modifier.fillMaxSize()) {
        HorizontalPager(count = 3, state = pagerState) { page ->
            when (page) {
                0 -> {
                    IntroScreen(
                        title = "스트레칭하면 방이 깨끗해져요",
                        description = "하루 n분, 총 5번의 짧은 스트레칭을 통해 \n" +
                                "고양이에게 깨끗한 방을 만들어주세요. ",
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
                        title = "깨끗한 방의 유지 기간은 하루!",
                        description = "이 엉뚱한 고양이는 하루가 지나면 \n" +
                                "방을 또 어질러요.",
                        currentPagerIndex = 1,
                        totalPagerCount = 3,
                        onButtonClicked = {
                            scope.launch {
                                pagerState.animateScrollToPage(page + 1)
                            }
                        }
                    )
                }
                2 -> {
                    IntroScreen(
                        title = "그래도 고양이는 귀여우니까 \uD83D\uDC95",
                        description = "방을 치워주면서 스트레칭 습관을 길러보세요. 그럼 고양이 이름부터 지어볼까요?!",
                        currentPagerIndex = 2,
                        totalPagerCount = 3,
                        onButtonClicked = { navigateToCatName() }
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
