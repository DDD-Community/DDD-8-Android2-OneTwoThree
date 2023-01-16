package com.inseoul.data.mapper

import com.example.common.Mapper
import com.inseoul.data.model.AuthInfoData
import javax.inject.Inject

class AuthInfoDataDomainMapper @Inject constructor() :
    Mapper<AuthInfoData, com.inseoul.domain.entity.AuthInfoData> {
    override fun from(input: AuthInfoData?): com.inseoul.domain.entity.AuthInfoData {
        return com.inseoul.domain.entity.AuthInfoData(
            memberId = input?.memberId,
            nickname = input?.nickname
        )
    }

    override fun to(output: com.inseoul.domain.entity.AuthInfoData?): AuthInfoData {
        return AuthInfoData(
            memberId = output?.memberId,
            nickname = output?.nickname
        )
    }
}