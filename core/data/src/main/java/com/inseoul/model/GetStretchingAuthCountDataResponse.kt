package com.inseoul.model

data class GetStretchingAuthCountDataResponse(
    val data: StretchingAuthCount?
)

data class StretchingAuthCount(
    val stretchingAuthCount: Int?
)
