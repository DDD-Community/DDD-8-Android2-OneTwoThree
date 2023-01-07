package com.inseoul.source

import com.inseoul.model.AuthInfoResponse
import com.inseoul.model.ChangeNicknameResponse
import com.inseoul.model.EnrollMemberInfoResponse
import com.inseoul.model.GetStretchingDayResponse

interface NetworkDataSource {

    // 회원정보 등록 API
    suspend fun enrollMemberInfo(
        nickname: String,
        firebaseToken: String
    ): EnrollMemberInfoResponse

    // 회원정보 조회 API
    suspend fun getMemberInfo(): AuthInfoResponse

    // 닉네임 변경 API
    suspend fun changeNickname(
        onetwothree_member_id: Int,
        nickname: String
    )

    // 알람 추가 API
    suspend fun addAlarm(
        onetwothree_member_id: Int,
        excludeHoliday: Boolean,
        count: Int
    ): ChangeNicknameResponse

    // 알람 삭제 API
    suspend fun deleteAlarm(
    alarm_id: Int?
    )

    // 알람 조회 API
    suspend fun getAlarm()

    // 스트레칭 시작 API
    suspend fun startStretching()

    //스트레칭 목록 조회 API
    suspend fun getStretching()

    suspend fun getStretchingMonth(
        onetwothree_member_id: Int,
        year: Int?,
        month: Int?
    )

    suspend fun getStretchingDay(
        onetwothree_member_id: Int,
        year: Int?,
        month: Int?,
        day: Int?
    ): GetStretchingDayResponse

    suspend fun getStretchingCount(
        onetwothree_member_id: Int
    )

}