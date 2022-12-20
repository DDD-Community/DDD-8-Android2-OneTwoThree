package com.inseoul.alarmsetting

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.inseoul.designsystem.icon.InseoulIcons
import com.inseoul.designsystem.switchbutton.InseoulSwitch
import com.inseoul.designsystem.toolbar.InseoulToolbar

@Composable
fun AlarmSettingScreen() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Scaffold(
            topBar =
            {
                InseoulToolbar(
                    modifier = Modifier,
                    title = "알림",
                    backButtonImageResource = InseoulIcons.ArrowBack,
                    leftImageResource = null,
                    centerImageResource = null,
                    rightImageResource = null,
                    onImageClicked = {
                        // 뒤로 가기 기능 추가 
                    }
                )
            },
            content = {
                // 일주일 캘린더
                HolidayAlarm()
                // 알림 시간 -> dropDownMenu merge되면 구현해주기!
            }
        ) 
    }
}

@Composable
fun HolidayAlarm() {
    Row {
        Column {
            Text(text = "공휴일에 알람 끄기")
            Text(text = "대체 혹은 임시 공휴일은 포함하지 않아요.")
        }
        InseoulSwitch(width = 52.dp, height = 32.dp, gapBetweenThumbAndTrackEdge = 4.dp)
    }
}



@Preview
@Composable
fun AlarmSettingPreview() {
    InseoulSwitch(width = 52.dp, height = 32.dp, gapBetweenThumbAndTrackEdge = 4.dp)
}