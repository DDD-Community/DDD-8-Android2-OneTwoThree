package com.inseoul.data.model

import com.example.common.Constants

data class AuthInfoDataResponse(
    val data: AuthInfoData?
)

data class AuthInfoData(
    val memberId: Int = 0,
    val nickname: String? = Constants.EMPTY_STRING
)
