package com.inseoul.network.mapper

import com.example.common.Mapper
import com.inseoul.data.model.AuthInfoDataResponse
import com.inseoul.network.model.AuthInfoData
import com.inseoul.network.model.AuthInfoNetworkResponse
import javax.inject.Inject

class AuthInfoNetworkDataMapper @Inject constructor() :
    Mapper<AuthInfoData, com.inseoul.data.model.AuthInfoData> {
    override fun from(i: AuthInfoData?): com.inseoul.data.model.AuthInfoData {
        return com.inseoul.data.model.AuthInfoData(
            memberId = i?.memberId,
            nickname = i?.nickname
        )
    }

    override fun to(o: com.inseoul.data.model.AuthInfoData?): AuthInfoData {
        return AuthInfoData(
            memberId = o?.memberId,
            nickname = o?.nickname
        )
    }
}