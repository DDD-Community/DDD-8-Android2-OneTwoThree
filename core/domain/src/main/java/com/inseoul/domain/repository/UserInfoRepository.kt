package com.inseoul.domain.repository

import com.inseoul.domain.entity.AuthInfoData

interface UserInfoRepository {
    var userToken: String

    suspend fun registerUserInfo(
        nickname: String,
        firebaseToken: String
    ): AuthInfoData
}
