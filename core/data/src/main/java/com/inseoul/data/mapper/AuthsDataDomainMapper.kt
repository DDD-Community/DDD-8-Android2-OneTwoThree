package com.inseoul.data.mapper

import com.example.common.Mapper
import com.inseoul.data.model.Auths
import com.inseoul.data.model.GetStretchingDayDataResponse
import com.inseoul.domain.entity.GetStretchingDayEntityResponse
import javax.inject.Inject

class AuthsDataDomainMapper @Inject constructor() :
    Mapper<Auths, com.inseoul.domain.entity.Auths> {
    override fun from(i: Auths?): com.inseoul.domain.entity.Auths {
        return com.inseoul.domain.entity.Auths(
            time = i?.time,
            stretchingType = i?.stretchingType
        )
    }

    override fun to(o: com.inseoul.domain.entity.Auths?): Auths {
        return Auths(
            time = o?.time,
            stretchingType = o?.stretchingType
        )
    }
}


class GetStretchingDayDataDomainMapper @Inject constructor() :
    Mapper<GetStretchingDayDataResponse, GetStretchingDayEntityResponse> {
    override fun from(i: GetStretchingDayDataResponse?): GetStretchingDayEntityResponse {
        val authsDataDomainMapper = AuthsDataDomainMapper()
        val authsList = listOf<Auths>()
        return GetStretchingDayEntityResponse(
            authCount = i?.authCount,
            auths = authsDataDomainMapper.fromList(authsList)
        )
    }

    override fun to(o: GetStretchingDayEntityResponse?): GetStretchingDayDataResponse {
        val authsDataDomainMapper = AuthsDataDomainMapper()
        val authsList = listOf<com.inseoul.domain.entity.Auths>()
        return GetStretchingDayDataResponse(
            authCount = o?.authCount,
            auths = authsDataDomainMapper.toList(authsList)
        )
    }
}