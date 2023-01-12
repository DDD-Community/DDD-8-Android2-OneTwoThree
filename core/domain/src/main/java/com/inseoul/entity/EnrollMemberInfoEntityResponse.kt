package com.inseoul.entity

data class EnrollMemberInfoEntityResponse(
    //@SerializedName("data")
    val data: MemberId?
)

data class MemberId(
    //@SerializedName("memberId")
    val memberId: Int?
)
