package com.inseoul.data.source

import com.inseoul.data.model.AuthInfoData

interface UserInfoDataSource {
    suspend fun registerUserInfo(
        nickname: String,
        firebaseToken: String
    ): AuthInfoData
}
