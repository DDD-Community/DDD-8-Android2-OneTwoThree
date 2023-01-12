package com.inseoul.network.model

import com.google.gson.annotations.SerializedName

data class EnrollMemberInfoNetworkResponse(
    @SerializedName("data") val data: MemberId?
)

data class MemberId(
    @SerializedName("memberId") val memberId: Int?
)
