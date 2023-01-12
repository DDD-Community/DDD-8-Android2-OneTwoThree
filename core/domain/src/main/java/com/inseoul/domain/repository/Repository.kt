package com.inseoul.domain.repository

import com.inseoul.domain.entity.*
import kotlinx.coroutines.flow.Flow

interface Repository {

    // 회원정보 등록 API
    suspend fun enrollMemberInfo(
        nickname: String,
        firebaseToken: String
    ): Flow<MemberId>

    // 회원정보 조회 API
    suspend fun getMemberInfo(
        firebase_token: String
    ): Flow<AuthInfoData>

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
    ): Flow<List<GetAlarmData>>

    // 스트레칭 시작 API
    suspend fun startStretching(): Flow<StartStretchingEntityResponse>

    //스트레칭 목록 조회 API
    suspend fun getStretching(): Flow<GetStretchingEntityResponse>

    // 월별 인증내역 조회 API (패스)
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
    ): Flow<List<Auths>>

    // 인증 API
    suspend fun getStretchingCount(
        onetwothree_member_id: Int,
        stretchingType: String
    ): Flow<StretchingAuthCount>
}