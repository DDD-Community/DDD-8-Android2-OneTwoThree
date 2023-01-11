package com.inseoul.model

data class GetAlarmDataResponse(
    val data: GetAlarmData?
)

data class GetAlarmData(
    val alarmId: Int?,
    val dayOfWeeks: List<String>?,
    val excludeHoliday: Boolean?,
    val count: Int?,
    val pushTimeList: List<String>?
)
