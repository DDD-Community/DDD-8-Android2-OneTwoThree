package com.inseoul.network.api

import com.inseoul.network.model.*
import retrofit2.http.*

interface StretchingAPI {

    // 회원정보 등록 API
    @Headers("Content-Type: application/json")
    @POST("/api/member")
    @FormUrlEncoded
    suspend fun enrollMemberInfo(
        @Field("nickname") nickname: String,
        @Field("firebaseToken") firebaseToken: String
    ): EnrollMemberInfoNetworkResponse

    // 회원정보 조회 API
    @GET("/api/member?firebase_token=?")
    suspend fun getMemberInfo(
        @Query("firebase_token") firebase_token: String
    ): AuthInfoNetworkResponse

    // 닉네임 변경 API
    @Headers("Content-Type: application/json")
    @PUT("/api/member/nickname")
    @FormUrlEncoded // @Field가 있는 경우 추가!
    suspend fun changeNickname(
        @Header("onetwothree-member-id") onetwothreeMemberId: Int,
        @Field("nickname") nickname: String
    )

    // 알람 추가 API
    @Headers("Content-Type: application/json")
    @POST("/api/alarm")
    @FormUrlEncoded
    suspend fun addAlarm(
        @Header("onetwothree-member-id") onetwothreeMemberId: Int,
        @Field("dayOfWeeks") dayOfWeeks: List<String>,
        @Field("excludeHoliday") excludeHoliday: Boolean,
        @Field("startTime") startTime: String,
        @Field("endTime") endTime: String,
        @Field("count") count: Int
    )

    // 알람 삭제 API
    @DELETE("/api/alarm/{alarm_id}")
    suspend fun deleteAlarm(
        @Path("alarm_id") alarm_id: Int?,
    )

    // 알람 조회 API -> 왜 response 리스트인지 체크??
    @GET("/api/alarm")
    suspend fun getAlarm(
        @Header("onetwothree-member-id") onetwothreeMemberId: Int
    ): GetAlarmNetworkResponse

    // 스트레칭 시작 API
    @GET("/api/streching/start")
    suspend fun startStretching(): StartStretchingNetworkResponse

    //스트레칭 목록 조회 API
    @GET("/api/streching")
    suspend fun getStretching(): GetStretchingNetworkResponse

    /*
    TODO 월별 인증내역 조회 API
    @GET("/api/auth/{year}/{month}")
    suspend fun getStretchingMonth(
        @Header("onetwothree-member-id") onetwothreeMemberId: Int,
        @Path("year") year: Int?,
        @Path("month") month: Int?
    )
    */

    // 일별 인증내역 조회 API
    @GET("/api/auth/{year}/{month}/{day}")
    suspend fun getStretchingDay(
        @Header("onetwothree-member-id") onetwothreeMemberId: Int,
        @Path("year") year: Int?,
        @Path("month") month: Int?,
        @Path("day") day: Int?
    ): GetStretchingDayNetworkResponse

    // 인증 API
    @Headers("Content-Type: application/json")
    @POST("/api/auth")
    @FormUrlEncoded
    suspend fun getStretchingAuthCount(
        @Header("onetwothree-member-id") onetwothreeMemberId: Int,
        @Field("stretchingType") stretchingType: String
    ): GetStretchingAuthCountNetworkResponse

}