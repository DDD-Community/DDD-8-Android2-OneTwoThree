package com.inseoul.model

data class AuthInfoResponse(
    val status: Int,
    val data: AuthInfoData
    )

data class AuthInfoData(
    val memberId: Int,
    val nickname: String
)
