package com.inseoul.data.mapper

import com.example.common.Mapper
import com.inseoul.data.model.Auths
import com.inseoul.data.model.GetStretchingDayDataResponse
import com.inseoul.domain.entity.GetStretchingDayEntityResponse
import javax.inject.Inject

class AuthsDataDomainMapper @Inject constructor() :
    Mapper<Auths, com.inseoul.domain.entity.Auths> {
    override fun from(input: Auths?): com.inseoul.domain.entity.Auths {
        return com.inseoul.domain.entity.Auths(
            time = input?.time,
            stretchingType = input?.stretchingType
        )
    }

    override fun to(output: com.inseoul.domain.entity.Auths?): Auths {
        return Auths(
            time = output?.time,
            stretchingType = output?.stretchingType
        )
    }
}


class GetStretchingDayDataDomainMapper @Inject constructor() :
    Mapper<GetStretchingDayDataResponse, GetStretchingDayEntityResponse> {
    override fun from(input: GetStretchingDayDataResponse?): GetStretchingDayEntityResponse {
        val authsDataDomainMapper = AuthsDataDomainMapper()
        val authsList = listOf<Auths>()
        return GetStretchingDayEntityResponse(
            authCount = input?.authCount,
            auths = authsDataDomainMapper.fromList(authsList)
        )
    }

    override fun to(output: GetStretchingDayEntityResponse?): GetStretchingDayDataResponse {
        val authsDataDomainMapper = AuthsDataDomainMapper()
        val authsList = listOf<com.inseoul.domain.entity.Auths>()
        return GetStretchingDayDataResponse(
            authCount = output?.authCount,
            auths = authsDataDomainMapper.toList(authsList)
        )
    }
}