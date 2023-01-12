package com.inseoul.domain.entity

data class EnrollMemberInfoEntityResponse(
    //@SerializedName("data")
    val data: MemberId?
)

data class MemberId(
    //@SerializedName("memberId")
    val memberId: Int?
)
