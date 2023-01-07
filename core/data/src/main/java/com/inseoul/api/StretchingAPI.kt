package com.inseoul.api

import com.inseoul.model.AuthInfoResponse
import com.inseoul.model.ChangeNicknameResponse
import com.inseoul.model.EnrollMemberInfoResponse
import com.inseoul.model.GetStretchingDayResponse
import retrofit2.http.DELETE
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

// 타입 확인하기..!

interface StretchingAPI {

   /* @GET("15077586/v1/centers")
    suspend fun getVaccinationCenter(
        @Query("page") page: Int,
        @Query("perPage") perPage: Int,
        @Query("serviceKey") serviceKey: String = SERVICE_KEY
    ): VaccinationCenterResponse*/

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
    ): ChangeNicknameResponse

    // 알람 추가 API (헤더)
    @POST("/api/alarm")
    suspend fun addAlarm(
        @Header("onetwothree-member-id") onetwothree_member_id: Int,
        //@Query("dayOfWeeks") dayOfWeeks: ["MONDAY", "FRIDAY"],
        @Query("excludeHoliday") excludeHoliday: Boolean,
        // @Query("startTime") startTime: "09:00"...
        // @Query("endTime") endTime: "18:00",
        @Query("count") count: Int
    ) : ChangeNicknameResponse  // 상태만 표시해서 일단 이것으로 대체

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
    )

    // 스트레칭 시작 API
    @GET("/api/streching/start")
    suspend fun startStretching()

    //스트레칭 목록 조회 API
    @GET("/api/streching")
    suspend fun getStretching()

    // 월별 인증내역 조회 API (헤더)
    @GET("/api/auth/{year}/{month}")
    suspend fun getStretchingMonth(
        @Header("onetwothree-member-id") onetwothree_member_id: Int,
        @Query("year") year: Int?,
        @Query("month") month: Int?
    )

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
    suspend fun getStretchingCount(
        @Header("onetwothree-member-id") onetwothree_member_id: Int
    )

}