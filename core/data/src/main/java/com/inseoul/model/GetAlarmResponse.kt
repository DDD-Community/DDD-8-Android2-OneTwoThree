package com.inseoul.model

import com.google.gson.annotations.SerializedName

data class GetAlarmResponse(
    @SerializedName("data") val data: GetAlarmData?
)

data class GetAlarmData(
    val alarmId: Int,
    val dayOfWeeks: List<String>,
    val excludeHoliday: Boolean,
    val count: Int,
    val pushTimeList: List<String>
)
