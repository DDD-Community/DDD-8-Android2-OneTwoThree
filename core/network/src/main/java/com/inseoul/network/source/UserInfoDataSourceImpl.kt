package com.inseoul.network.source

import com.inseoul.data.model.AuthInfoData
import com.inseoul.data.source.UserInfoDataSource
import com.inseoul.network.api.MemberAPI
import com.inseoul.network.mapper.toData
import javax.inject.Inject

class UserInfoDataSourceImpl @Inject constructor(
    private val memberAPI: MemberAPI
) : UserInfoDataSource {
    override suspend fun registerUserInfo(nickname: String, firebaseToken: String): AuthInfoData {
        return memberAPI.enrollMemberInfo(nickname, firebaseToken).toData()
    }
}
