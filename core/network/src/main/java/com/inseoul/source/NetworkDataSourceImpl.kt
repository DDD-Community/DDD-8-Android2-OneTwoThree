package com.inseoul.source

import com.inseoul.api.StretchingAPI
import com.inseoul.model.*
import javax.inject.Inject

class NetworkDataSourceImpl @Inject constructor(
    private val stretchingAPI: StretchingAPI
) : NetworkDataSource {
    override suspend fun enrollMemberInfo(
        nickname: String,
        firebaseToken: String
    ): EnrollMemberInfoDataResponse {
        TODO("Not yet implemented")
    }

    override suspend fun getMemberInfo(): AuthInfoDataResponse {
        TODO("Not yet implemented")
    }

    override suspend fun changeNickname(onetwothreeMemberId: Int, nickname: String) {
        TODO("Not yet implemented")
    }

    override suspend fun addAlarm(
        onetwothreeMemberId: Int,
        dayOfWeeks: List<String>,
        excludeHoliday: Boolean,
        startTime: String,
        endTime: String,
        count: Int
    ) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteAlarm(alarm_id: Int?) {
        TODO("Not yet implemented")
    }

    override suspend fun getAlarm(onetwothreeMemberId: Int): GetAlarmDataResponse {
        TODO("Not yet implemented")
    }

    override suspend fun startStretching(): StartStretchingDataResponse {
        TODO("Not yet implemented")
    }

    override suspend fun getStretching(): GetStretchingDataResponse {
        TODO("Not yet implemented")
    }

    override suspend fun getStretchingMonth(onetwothreeMemberId: Int, year: Int?, month: Int?) {
        TODO("Not yet implemented")
    }

    override suspend fun getStretchingDay(
        onetwothreeMemberId: Int,
        year: Int?,
        month: Int?,
        day: Int?
    ): GetStretchingDayDataResponse {
        TODO("Not yet implemented")
    }

    override suspend fun getStretchingCount(
        onetwothree_member_id: Int,
        stretchingType: String
    ): GetStretchingAuthCountDataResponse {
        TODO("Not yet implemented")
    }

}