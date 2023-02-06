package com.inseoul.alarmsetting

import android.annotation.SuppressLint
import android.graphics.drawable.shapes.Shape
import android.util.Log
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.inseoul.designsystem.dropdownmenu.InSeoulDropDownMenu
import com.inseoul.designsystem.icon.InseoulIcons
import com.inseoul.designsystem.switchbutton.InseoulSwitch
import com.inseoul.designsystem.theme.*
import com.inseoul.designsystem.toolbar.InseoulToolbar
import com.inseoul.onetwothree.ui.theme.Typography
import com.inseoul.onetwothree.ui.theme.pretendard

val timeList = listOf("9:00", "10:00", "11:00", "12:00", "13:00", "14:00")
val count = listOf("1번", "2번", "3번")

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AlarmSettingScreen(
    navigateToBack: () -> Unit,
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = bg
    ) {
        Scaffold(
            topBar = {
                InseoulToolbar(
                    modifier = Modifier,
                    title = "알림",
                    backButtonImageResource = InseoulIcons.ArrowBack,
                    onImageClicked = navigateToBack
                )
            },

            content = {
                val switchOn = remember { mutableStateOf(false) }
                
                Column {
                    AlarmWeek()
                    HolidayAlarm(switchOn)
                    AlarmTimer(timeList, timeList , count)
                    Spacer(modifier = Modifier.height(240.dp))
                    SaveButton()
                }
            }
        )
    }
}

@Composable
fun HolidayAlarm(switchOn: MutableState<Boolean>) {
    Row(
        modifier = Modifier.padding(16.dp)
    ) {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(text = "공휴일에 알람 끄기", style = Typography.body2, color = gray900)
            Text(
                text = "대체 혹은 임시 공휴일은 포함하지 않아요.",
                fontFamily = pretendard,
                fontSize = 12.sp,
                color = gray600
            )
        }
        InseoulSwitch(
            width = 52.dp,
            height = 32.dp,
            gapBetweenThumbAndTrackEdge = 4.dp,
            switchOn = switchOn
        )

    }
}

@Composable
fun AlarmTimer(
    listStartTime: List<String>,
    listEndTime: List<String>,
    listAlarmCount: List<String>
) {

    val currentValueStartTime = remember { mutableStateOf(listStartTime[0]) }
    val currentValueEndTime = remember { mutableStateOf(listEndTime[0]) }
    val alarmCount = remember { mutableStateOf(listAlarmCount[0]) }

    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(
            modifier = Modifier.padding(bottom = 16.dp),
            text = "알림 시간", style = Typography.body2, color = gray900
        )
        Row {
            TimerComponent(text = "시작", listStartTime, currentValueStartTime)
            Spacer(modifier = Modifier.width(24.dp))
            TimerComponent("종료", listEndTime, currentValueEndTime)
        }
        Text(
            modifier = Modifier.padding(top = 40.dp, bottom = 16.dp),
            text = "알림 횟수", style = Typography.body2, color = gray900
        )

        InSeoulDropDownMenu(list = listAlarmCount,
            currentValue = alarmCount
            )
    }
}

@Composable
fun TimerComponent(text: String,
                   list: List<String>,
                   currentValue: MutableState<String>) {
    Column {
        Text(
            modifier = Modifier.padding(bottom = 4.dp),
            text = text,
            fontFamily = pretendard,
            fontSize = 12.sp,
            color = gray600
        )
        InSeoulDropDownMenu(list = list,
            currentValue = currentValue
            )
    }
}

@Composable
fun SaveButton() {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(84.dp)
            .padding(start = 16.dp, end = 16.dp, bottom = 24.dp),
        shape = RoundedCornerShape(16.dp),
        onClick = { /* 저장 기능 */ }) {
        Text(
            text = "저장",
            style = Typography.body1
        )
    }
}

@Composable
fun AlarmWeek() {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)
    ) {
        Text(text = "요일 반복", style = Typography.body2, color = gray900)
        Row(horizontalArrangement = Arrangement.spacedBy(28.dp)) {
            TextColor(text = "월")
            TextColor(text = "화")
            TextColor(text = "수")
            TextColor(text = "목")
            TextColor(text = "금")
            TextColor(text = "토")
            TextColor(text = "일")
        }
    }

}

@Composable
fun TextColor(text: String,
              alarmSettingViewModel: AlarmSettingViewModel = viewModel()) {
    var isSelected by remember { mutableStateOf(false) }
    val textColor: Color by animateColorAsState(
        targetValue = when (isSelected) {
            true -> Green300
            false -> Color.White
        },
        animationSpec = tween()
    )
    Text(text = text,
        color = gray900,
        fontSize = 16.sp,
        modifier = Modifier
            .background(shape = RoundedCornerShape(40.dp), color = textColor)
            .clickable {
                isSelected = !isSelected
                alarmSettingViewModel.addAlarmDay(text)
                val alarmDate = alarmSettingViewModel.alarmDay
                alarmDate.map {
                    println(it)
                }
            }
    )
}

@Preview
@Composable
fun AlarmWeekPreview() {
    AlarmWeek()
}

@Preview
@Composable
fun AlarmSettingPreview() {
    AlarmSettingScreen(
        navigateToBack = {}
    )
}