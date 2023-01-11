package com.inseoul.model

import com.google.gson.annotations.SerializedName

// 왜 리스트지?
data class GetAlarmNetworkResponse(
    @SerializedName("data") val data: List<GetAlarmNetworkData>
)

data class GetAlarmNetworkData(
    val alarmId: Int?,
    val dayOfWeeks: List<String>?,
    val excludeHoliday: Boolean?,
    val count: Int?,
    val pushTimeList: List<String>?
)
