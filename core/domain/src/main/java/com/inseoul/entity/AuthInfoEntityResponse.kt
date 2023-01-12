package com.inseoul.entity

data class AuthInfoEntityResponse(
    val data: AuthInfoData?
)

data class AuthInfoData(
    val memberId: Int,
    val nickname: String
)
