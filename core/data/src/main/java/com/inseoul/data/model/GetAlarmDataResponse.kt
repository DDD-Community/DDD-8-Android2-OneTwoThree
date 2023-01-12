package com.inseoul.data.model

data class GetAlarmDataResponse(
    val data: List<GetAlarmData>?
)

data class GetAlarmData(
    val alarmId: Int?,
    val dayOfWeeks: List<String>?,
    val excludeHoliday: Boolean?,
    val count: Int?,
    val pushTimeList: List<String>?
)
