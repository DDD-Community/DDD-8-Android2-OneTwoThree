package com.inseoul.api

import com.inseoul.model.*
import retrofit2.Response
import retrofit2.http.*

// todo 타입 확인하기

/*
@Path - 동적으로 경로를 사용하기 위한 어노테이션
@Query, @QueryMap - @GET 에서 사용하며 조건 파라미터를 설정
@Field, @FieldMap - @POST 에서 사용하며 조건 파라미터를 설정
@Body - 객체를 이용하여 조건 파라미터를 설정
@Header - 해더 설정

url 중 {}가 있으면 -> @path 사용해야 하는듯
*/



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
    // todo 월별 인증내역 조회 API
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