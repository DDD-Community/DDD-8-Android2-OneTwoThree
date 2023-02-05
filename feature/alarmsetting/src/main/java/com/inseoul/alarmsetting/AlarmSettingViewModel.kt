package com.inseoul.alarmsetting

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class AlarmSettingViewModel: ViewModel() {

    private val _alarmDay = mutableStateListOf<String>()
    val alarmDay: List<String> = _alarmDay

    fun addAlarmDay(day: String) {
        _alarmDay.add(day)

        Log.d("AlarmSettingVM", "addAlarmDay: ${_alarmDay.last()}")
    }
}