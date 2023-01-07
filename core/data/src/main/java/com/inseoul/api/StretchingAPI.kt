package com.inseoul.api

import com.inseoul.model.*
import retrofit2.http.*

// todo 타입 확인하기

interface StretchingAPI {

    // 회원정보 등록 API
    @POST("/api/member")
    suspend fun enrollMemberInfo(
        @Field("nickname") nickname: String,
        @Field("firebaseToken") firebaseToken: String
    ) : EnrollMemberInfoResponse

    // 회원정보 조회 API
    @GET("/api/member?firebase_token=?")
    suspend fun getMemberInfo(
        @Query("firebase_token") firebase_token: String
    ): AuthInfoResponse

    // 닉네임 변경 API (헤더)
    @PUT("/api/member/nickname")
    suspend fun changeNickname(
        @Header("onetwothree-member-id") onetwothree_member_id: Int,
        @Field("nickname") nickname: String
    )

    // 알람 추가 API (헤더)
    @POST("/api/alarm")
    suspend fun addAlarm(
        @Header("onetwothree-member-id") onetwothree_member_id: Int,
        @Query("dayOfWeeks") dayOfWeeks: List<String>,  // 맞나?
        @Query("excludeHoliday") excludeHoliday: Boolean,
        @Query("startTime") startTime: String,
        @Query("endTime") endTime: String,
        @Query("count") count: Int
    )

    // 알람 삭제 API
    @DELETE("/api/alarm/{alarm_id}")
    suspend fun deleteAlarm(
        @Path("alarm_id") alarm_id: Int?,
        // ...
    )

    // 알람 조회 API (헤더)
    @GET("/api/alarm")
    suspend fun getAlarm(
        @Header("onetwothree-member-id") onetwothree_member_id: Int
    ): GetAlarmResponse

    // 스트레칭 시작 API
    @GET("/api/streching/start")
    suspend fun startStretching(): StartStretchingResponse

    //스트레칭 목록 조회 API
    @GET("/api/streching")
    suspend fun getStretching(): GetStretchingResponse

    // 월별 인증내역 조회 API (헤더)
    @GET("/api/auth/{year}/{month}")
    suspend fun getStretchingMonth(
        @Header("onetwothree-member-id") onetwothree_member_id: Int,
        @Query("year") year: Int?,
        @Query("month") month: Int?
    )   // 요거 어떻게 표기?

    // 일별 인증내역 조회 API (헤더)
    @GET("/api/auth/{year}/{month}/{day}")
    suspend fun getStretchingDay(
        @Header("onetwothree-member-id") onetwothree_member_id: Int,
        @Query("year") year: Int?,
        @Query("month") month: Int?,
        @Query("day") day: Int?
    ): GetStretchingDayResponse

    // 인증 API (헤더)
    @POST("/api/auth")
    suspend fun getStretchingAuthCount(
        @Header("onetwothree-member-id") onetwothree_member_id: Int
    ): GetStretchingAuthCountResponse

}