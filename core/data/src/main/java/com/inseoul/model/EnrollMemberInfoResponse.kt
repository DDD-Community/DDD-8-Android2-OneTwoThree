package com.inseoul.model

import com.google.gson.annotations.SerializedName

data class EnrollMemberInfoResponse(
    @SerializedName("data") val data: MemberId?
)

data class MemberId(
    @SerializedName("memberId") val memberId: Int?
)
