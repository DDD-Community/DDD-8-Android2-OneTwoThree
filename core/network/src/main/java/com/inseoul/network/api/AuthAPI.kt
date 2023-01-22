package com.inseoul.network.api

import com.inseoul.network.model.GetStretchingAuthCountNetworkResponse
import com.inseoul.network.model.GetStretchingDayNetworkResponse
import retrofit2.http.*

interface AuthAPI {

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