package com.inseoul.data.model

data class EnrollMemberInfoDataResponse(
    //@SerializedName("data")
    val data: MemberId?
)

data class MemberId(
    //@SerializedName("memberId")
    val memberId: Int?
)
