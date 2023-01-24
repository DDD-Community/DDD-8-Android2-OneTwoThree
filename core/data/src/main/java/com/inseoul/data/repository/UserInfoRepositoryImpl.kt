package com.inseoul.data.repository

import com.inseoul.data.source.UserInfoDataSource
import com.inseoul.data.toDomain
import com.inseoul.domain.entity.AuthInfoData
import com.inseoul.domain.repository.UserInfoRepository
import javax.inject.Inject

class UserInfoRepositoryImpl @Inject constructor(
    private val userInfoDataSource: UserInfoDataSource
) : UserInfoRepository {
    override suspend fun registerUserInfo(nickname: String, firebaseToken: String): AuthInfoData {
        return userInfoDataSource.registerUserInfo(nickname, firebaseToken).toDomain()
    }
}
