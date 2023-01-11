package com.inseoul.model

data class EnrollMemberInfoDataResponse(
    //@SerializedName("data")
    val data: MemberId?
)

data class MemberId(
    //@SerializedName("memberId")
    val memberId: Int?
)
