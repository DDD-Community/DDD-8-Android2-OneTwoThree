package com.inseoul.data.model

data class AuthInfoDataResponse(
    val data: AuthInfoData?
)

data class AuthInfoData(
    val memberId: Int?,
    val nickname: String?
)
