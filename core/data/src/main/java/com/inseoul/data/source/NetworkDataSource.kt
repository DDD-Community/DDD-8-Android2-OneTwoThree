package com.inseoul.data.source

import com.inseoul.data.model.*


interface NetworkDataSource {

    // 회원정보 등록 API
    suspend fun enrollMemberInfo(
        nickname: String,
        firebaseToken: String
    ): MemberId

    // 회원정보 조회 API
    suspend fun getMemberInfo(
        firebase_token: String
    ): AuthInfoData

    // 닉네임 변경 API
    suspend fun changeNickname(
        onetwothreeMemberId: Int,
        nickname: String
    )

    // 알람 추가 API
    suspend fun addAlarm(
        onetwothreeMemberId: Int,
        dayOfWeeks: List<String>,
        excludeHoliday: Boolean,
        startTime: String,
        endTime: String,
        count: Int
    )

    // 알람 삭제 API
    suspend fun deleteAlarm(
    alarm_id: Int?
    )

    // 알람 조회 API
    suspend fun getAlarm(
        onetwothreeMemberId: Int,
    ): List<GetAlarmData>

    // 스트레칭 시작 API
    suspend fun startStretching(): StartStretchingDataResponse

    //스트레칭 목록 조회 API
    suspend fun getStretching(): GetStretchingDataResponse

    // 월별 인증내역 조회 API
    suspend fun getStretchingMonth(
        onetwothreeMemberId: Int,
        year: Int?,
        month: Int?
    )

    // 일별 일증내역 조회 API
    suspend fun getStretchingDay(
        onetwothreeMemberId: Int,
        year: Int?,
        month: Int?,
        day: Int?
    ): List<Auths>

    // 인증 API
    suspend fun getStretchingCount(
        onetwothree_member_id: Int,
        stretchingType: String
    ): StretchingAuthCount

}