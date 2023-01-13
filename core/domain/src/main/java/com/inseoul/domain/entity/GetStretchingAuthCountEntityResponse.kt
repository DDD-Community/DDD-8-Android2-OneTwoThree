package com.inseoul.domain.entity

data class GetStretchingAuthCountEntityResponse(
    val data: StretchingAuthCount?
)

data class StretchingAuthCount(
    val stretchingAuthCount: Int?
)
