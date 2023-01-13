package com.inseoul.network.model

data class EnrollMemberInfoNetworkResponse(
    val data: MemberId?
)

data class MemberId(
    val memberId: Int?
)
