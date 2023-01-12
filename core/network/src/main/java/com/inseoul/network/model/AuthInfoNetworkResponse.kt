package com.inseoul.network.model

import com.google.gson.annotations.SerializedName

data class AuthInfoNetworkResponse(
    @SerializedName("data") val data: AuthInfoData?

)

data class AuthInfoData(
    val memberId: Int?,
    val nickname: String?
)
