package com.inseoul.data.mapper

import com.example.common.Mapper
import com.inseoul.data.model.AuthInfoData
import com.inseoul.data.model.AuthInfoDataResponse
import com.inseoul.domain.entity.AuthInfoEntityResponse
import javax.inject.Inject

class AuthInfoDataDomainMapper @Inject constructor() :
    Mapper<AuthInfoData, com.inseoul.domain.entity.AuthInfoData> {
    override fun from(i: AuthInfoData?): com.inseoul.domain.entity.AuthInfoData {
        return com.inseoul.domain.entity.AuthInfoData(
            memberId = i?.memberId,
            nickname = i?.nickname
        )
    }

    override fun to(o: com.inseoul.domain.entity.AuthInfoData?): AuthInfoData {
        return AuthInfoData(
            memberId = o?.memberId,
            nickname = o?.nickname
        )
    }

}