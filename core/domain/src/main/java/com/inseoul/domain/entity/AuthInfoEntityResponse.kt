package com.inseoul.domain.entity

data class AuthInfoData(
    val memberId: Int = 0,
    val nickname: String = "" // NOTE : EMPTY_STRING 으로 변경요망
)
