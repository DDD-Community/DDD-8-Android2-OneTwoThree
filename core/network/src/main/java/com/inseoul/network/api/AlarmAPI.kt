package com.inseoul.network.api

import com.inseoul.network.model.GetAlarmNetworkResponse
import retrofit2.http.*

interface AlarmAPI {

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


}