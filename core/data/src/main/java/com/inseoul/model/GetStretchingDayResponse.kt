package com.inseoul.model

data class GetStretchingDayResponse(
    val status: Int,
    // val data: AuthData 명명 다기 해주기
)

data class AuthData(
    val authCount: Int,
    val auths: Auth
)

data class Auth(
    val time: String,
    // val stretchingType: "NECK", "SHOULDER"...
)