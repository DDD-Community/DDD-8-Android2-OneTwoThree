package com.inseoul.source

import com.inseoul.model.AuthInfoResponse
import com.inseoul.model.EnrollMemberInfoResponse
import com.inseoul.model.GetStretchingDayResponse

class NetworkDataSourceImpl : NetworkDataSource {

    override suspend fun enrollMemberInfo(
        nickname: String,
        firebaseToken: String
    ): EnrollMemberInfoResponse {
        TODO("Not yet implemented")
    }

    override suspend fun getMemberInfo(): AuthInfoResponse {
        TODO("Not yet implemented")
    }

    override suspend fun changeNickname(onetwothree_member_id: Int, nickname: String) {
        TODO("Not yet implemented")
    }

    override suspend fun addAlarm(
        onetwothree_member_id: Int,
        excludeHoliday: Boolean,
        count: Int
    ) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteAlarm(alarm_id: Int?) {
        TODO("Not yet implemented")
    }

    override suspend fun getAlarm() {
        TODO("Not yet implemented")
    }

    override suspend fun startStretching() {
        TODO("Not yet implemented")
    }

    override suspend fun getStretching() {
        TODO("Not yet implemented")
    }

    override suspend fun getStretchingMonth(onetwothree_member_id: Int, year: Int?, month: Int?) {
        TODO("Not yet implemented")
    }

    override suspend fun getStretchingDay(
        onetwothree_member_id: Int,
        year: Int?,
        month: Int?,
        day: Int?
    ): GetStretchingDayResponse {
        TODO("Not yet implemented")
    }

    override suspend fun getStretchingCount(onetwothree_member_id: Int) {
        TODO("Not yet implemented")
    }
}