package com.inseoul.onetwothree.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.stretching.arm.armStretchingRoute
import com.example.stretching.arm.armStretchingScreen
import com.example.stretching.finish.stretchingFinishRoute
import com.example.stretching.finish.stretchingFinishScreen
import com.example.stretching.list.stretchingListRoute
import com.example.stretching.list.stretchingListScreen
import com.example.stretching.neckdown.neckdownStretchingRoute
import com.example.stretching.neckdown.neckdownStretchingScreen
import com.example.stretching.neckup.neckupStretchingRoute
import com.example.stretching.neckup.neckupStretchingScreen
import com.example.stretching.shoulder.shoulderStretchingRoute
import com.example.stretching.shoulder.shoulderStretchingScreen
import com.example.stretching.wrist.wristStretchingRoute
import com.example.stretching.wrist.wristStretchingScreen
import com.inseoul.onboarding.navigation.onBoardingScreen
import com.treemiddle.calendar.screen.navigation.calendarRoute
import com.treemiddle.calendar.screen.navigation.onCalendarRoute
import com.treemiddle.catname.navigation.catNameRoute
import com.treemiddle.catname.navigation.onCatNameScreen
import com.treemiddle.setting.navigation.onSettingsScreen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun InseoulNavGraph(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = stretchingListRoute, //onBoardingRoute,
        modifier = modifier
    ) {
        onBoardingScreen {
            // NOTE : 임시로 캘린더 화면으로 이동합니다.
            navController.navigate(calendarRoute)
        }
        onCalendarRoute()
        onSettingsScreen(
            navigateToCatName = {
                navController.navigate(catNameRoute)
            },
            navigateToNotification = {
                // NOTE : 알림 화면으로 이동해야 합니다.
                // navController.navigate("알림화면 만들고 route 연결")
            }
        )
        onCatNameScreen {
            // NOTE : 닉네임을 입력하면 다음 화면으로 이동해야 합니다. (미정)
        }


        // 즐거운 스트레칭~!
        armStretchingScreen(
            navigateToFinish = {
                // 스트레칭 완료 화면으로 이동
                navController.navigate(stretchingFinishRoute)
            },
            navigateToBack = {
                navController.popBackStack()
            }
        )

        neckupStretchingScreen(
            navigateToFinish = {
                navController.navigate(stretchingFinishRoute)
            },
            navigateToBack = {
                navController.popBackStack()
            }
        )

        neckdownStretchingScreen(
            navigateToFinish =  {
                navController.navigate(stretchingFinishRoute)
            },
            navigateToBack = {
                navController.popBackStack()
            }
        )

        shoulderStretchingScreen(
            navigateToFinish = {
                navController.navigate(stretchingFinishRoute)
            },
            navigateToBack = {
                navController.popBackStack()
            }
        )

        wristStretchingScreen(
            navigateToFinish = {
                navController.navigate(stretchingFinishRoute)
            },
            navigateToBack = {
                navController.popBackStack()
            }
        )

        stretchingFinishScreen(
            navigateToBack = {
                navController.popBackStack()
            },
            navigateToArm = {
                navController.navigate(armStretchingRoute)
            },
            navigateToNeckdown = {
                navController.navigate(neckdownStretchingRoute)
            },
            navigateToNeckup = {
                navController.navigate(neckupStretchingRoute)
            },
            navigateToShoulder = {
                navController.navigate(shoulderStretchingRoute)
            },
            navigateToWrist = {
                navController.navigate(wristStretchingRoute)
            }
        )


        stretchingListScreen(
            navigateToBack = {
                navController.popBackStack()
            },
            navigateToArm = {
                navController.navigate(armStretchingRoute)
            },
            navigateToNeckdown = {
                navController.navigate(neckdownStretchingRoute)
            },
            navigateToNeckup = {
                navController.navigate(neckupStretchingRoute)
            },
            navigateToShoulder = {
                navController.navigate(shoulderStretchingRoute)
            },
            navigateToWrist = {
                navController.navigate(wristStretchingRoute)
            }
        )
    }
}

