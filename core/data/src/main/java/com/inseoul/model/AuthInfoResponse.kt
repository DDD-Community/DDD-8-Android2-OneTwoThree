package com.inseoul.model

import com.google.gson.annotations.SerializedName

data class AuthInfoResponse(
    @SerializedName("data") val data: AuthInfoData?

)

data class AuthInfoData(
    val memberId: Int,
    val nickname: String
)
