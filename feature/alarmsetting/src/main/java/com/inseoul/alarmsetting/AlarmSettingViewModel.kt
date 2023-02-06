package com.inseoul.alarmsetting

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class AlarmSettingViewModel : ViewModel() {

    private val _alarmDay = mutableStateListOf<String>()
    val alarmDay: List<String> = _alarmDay

    fun addAlarmDay(day: String) {
        // _alarmDay.add(day)

        if (_alarmDay.contains(day)) {
            _alarmDay.remove(day)
        } else {
            _alarmDay.add(day)
        }
        if (_alarmDay.isNullOrEmpty()) {
            Log.d("TAG", "addAlarmDay: 결과를 입력해주세요")
            _alarmDay.add("")
        }

        Log.d("AlarmSettingVM", "addAlarmDay: ${_alarmDay.last()}")
    }
}