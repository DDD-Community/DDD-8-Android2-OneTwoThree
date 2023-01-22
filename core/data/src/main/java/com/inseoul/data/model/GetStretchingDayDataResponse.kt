package com.inseoul.data.model

data class GetStretchingDayDataResponse(
    val authCount: Int?,
    val auths: List<Auths>?
)

data class Auths(
    val time: String?,
    val stretchingType: String?
)
