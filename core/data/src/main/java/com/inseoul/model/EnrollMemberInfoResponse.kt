package com.inseoul.model

data class EnrollMemberInfoResponse(
    val status: Int?,
    val data: EnrollData?
)

data class EnrollData(
    val memberId: Int?
)
