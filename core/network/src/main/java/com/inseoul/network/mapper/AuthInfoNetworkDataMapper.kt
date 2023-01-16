package com.inseoul.network.mapper

import com.example.common.Mapper
import com.inseoul.network.model.AuthInfoData
import javax.inject.Inject

class AuthInfoNetworkDataMapper @Inject constructor() :
    Mapper<AuthInfoData, com.inseoul.data.model.AuthInfoData> {
    override fun from(input: AuthInfoData?): com.inseoul.data.model.AuthInfoData {
        return com.inseoul.data.model.AuthInfoData(
            memberId = input?.memberId,
            nickname = input?.nickname
        )
    }

    override fun to(output: com.inseoul.data.model.AuthInfoData?): AuthInfoData {
        return AuthInfoData(
            memberId = output?.memberId,
            nickname = output?.nickname
        )
    }
}