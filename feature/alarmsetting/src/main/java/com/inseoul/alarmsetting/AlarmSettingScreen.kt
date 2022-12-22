package com.inseoul.alarmsetting

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.inseoul.designsystem.dropdownmenu.InSeoulDropDownMenu
import com.inseoul.designsystem.icon.InseoulIcons
import com.inseoul.designsystem.switchbutton.InseoulSwitch
import com.inseoul.designsystem.theme.gray600
import com.inseoul.designsystem.toolbar.InseoulToolbar
import com.inseoul.onetwothree.ui.theme.pretendard

val timeList = listOf("9:00","10:00","11:00","12:00","13:00","14:00")
val count = listOf("1번","2번","3번")

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AlarmSettingScreen() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Scaffold(
            topBar = {
                InseoulToolbar(
                    modifier = Modifier,
                    title = "알림",
                    backButtonImageResource = InseoulIcons.ArrowBack,
                    onImageClicked = {
                        // 뒤로 가기 기능 추가
                    }
                )
            },
            content = {
                // 일주일 캘린더
                Column {
                    HolidayAlarm()
                    AlarmTimer()
                    Spacer(modifier = Modifier.height(240.dp))
                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(80.dp)
                            .padding(start = 16.dp, end = 16.dp, bottom = 24.dp),
                        shape = RoundedCornerShape(16.dp),
                        onClick = { /* 저장 기능 */ }) {
                        Text(text = "저장", fontFamily = pretendard, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    }
                }
            }
        )
    }
}

@Composable
fun HolidayAlarm() {
    Row(
        modifier = Modifier.padding(16.dp)
    ) {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(text = "공휴일에 알람 끄기")
            Text(text = "대체 혹은 임시 공휴일은 포함하지 않아요.")
        }
        InseoulSwitch(width = 52.dp, height = 32.dp, gapBetweenThumbAndTrackEdge = 4.dp)
    }
}

@Composable
fun AlarmTimer() {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(
            modifier = Modifier.padding(bottom = 16.dp),
            text = "알림 시간", fontFamily = pretendard, fontWeight = FontWeight.Bold, fontSize = 14.sp)
            Row {
                TimerComponent(text = "시작")
                Spacer(modifier = Modifier.width(24.dp))
                TimerComponent("종료")
            }
        Text(
            modifier = Modifier.padding(top = 40.dp, bottom = 16.dp),
            text = "알림 횟수", fontFamily = pretendard, fontWeight = FontWeight.Bold, fontSize = 14.sp)
        InSeoulDropDownMenu(list = count)
    }
}

@Composable
fun TimerComponent(text: String) {
    Column {
        Text(
            modifier = Modifier.padding(bottom = 4.dp),
            text = text, fontFamily = pretendard, fontSize = 12.sp, color = gray600)
        InSeoulDropDownMenu(list = timeList)
    }
}



@Preview
@Composable
fun AlarmSettingPreview() {
    AlarmSettingScreen()
}