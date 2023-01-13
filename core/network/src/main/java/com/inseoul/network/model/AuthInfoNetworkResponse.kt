package com.inseoul.network.model

data class AuthInfoNetworkResponse(
    val data: AuthInfoData?
)

data class AuthInfoData(
    val memberId: Int?,
    val nickname: String?
)
