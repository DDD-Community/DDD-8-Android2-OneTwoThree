package com.inseoul.domain.entity

data class GetStretchingDayEntityResponse(
    val authCount: Int?,
    val auths: List<Auths>?
)

data class Auths(
    val time: String?,
    val stretchingType: String?
)
