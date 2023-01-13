package com.inseoul.network.model

data class GetAlarmNetworkResponse(
    val data: List<GetAlarmData>?
)

data class GetAlarmData(
    val alarmId: Int?,
    val dayOfWeeks: List<String>?,
    val excludeHoliday: Boolean?,
    val count: Int?,
    val pushTimeList: List<String>?
)
