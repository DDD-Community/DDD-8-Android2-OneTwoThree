package com.inseoul.entity

data class GetStretchingAuthCountEntityResponse(
    val data: StretchingAuthCount?
)

data class StretchingAuthCount(
    val stretchingAuthCount: Int?
)
