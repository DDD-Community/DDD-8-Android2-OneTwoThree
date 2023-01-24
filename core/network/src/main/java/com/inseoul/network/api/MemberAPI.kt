package com.inseoul.network.api

import com.inseoul.network.model.AuthInfoNetworkResponse
import com.inseoul.network.model.EnrollMemberInfoNetworkResponse
import retrofit2.http.*

interface MemberAPI {

    @POST("api/member")
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

}
