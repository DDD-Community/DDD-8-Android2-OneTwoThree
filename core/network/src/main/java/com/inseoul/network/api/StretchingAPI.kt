package com.inseoul.network.api

import com.inseoul.network.model.*
import retrofit2.http.*

interface StretchingAPI {



    // 스트레칭 시작 API
    @GET("/api/streching/start")
    suspend fun startStretching(): StartStretchingNetworkResponse

    //스트레칭 목록 조회 API
    @GET("/api/streching")
    suspend fun getStretching(): GetStretchingNetworkResponse


}