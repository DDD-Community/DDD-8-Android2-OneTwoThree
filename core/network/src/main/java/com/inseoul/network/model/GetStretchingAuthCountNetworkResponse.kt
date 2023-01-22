package com.inseoul.network.model

data class GetStretchingAuthCountNetworkResponse(
    val data: StretchingAuthCount?
)

data class StretchingAuthCount(
    val stretchingAuthCount: Int?
)
