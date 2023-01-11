package com.inseoul.model

data class GetStretchingAuthCountNetworkResponse(
    val data: StretchingAuthCount?
)

data class StretchingAuthCount(
    val stretchingAuthCount: Int?
)
