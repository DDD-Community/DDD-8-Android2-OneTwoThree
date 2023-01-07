package com.inseoul.model

data class GetStretchingDayResponse(
    val authCount: Int,
    val auths: Auths
)

data class Auths(
    val time: String,
    val stretchingType: String
)