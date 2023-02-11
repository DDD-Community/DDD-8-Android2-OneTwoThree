package com.inseoul.domain.params

data class RegisterUserInfoUseCaseParams(
    val nickname: String,
    val firebaseToken: String
)
