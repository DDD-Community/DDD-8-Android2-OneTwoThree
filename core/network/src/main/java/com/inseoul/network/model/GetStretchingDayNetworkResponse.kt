package com.inseoul.network.model


data class GetStretchingDayNetworkResponse(
    val authCount: Int?,
    val auths: List<Auths>?
)

data class Auths(
    val time: String?,
    val stretchingType: String?
)
