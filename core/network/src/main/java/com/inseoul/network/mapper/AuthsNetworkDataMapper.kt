package com.inseoul.network.mapper

import com.example.common.Mapper
import com.inseoul.data.model.GetStretchingDayDataResponse
import com.inseoul.network.model.Auths
import com.inseoul.network.model.GetStretchingDayNetworkResponse
import javax.inject.Inject

class AuthsNetworkDataMapper @Inject constructor() :
    Mapper<Auths, com.inseoul.data.model.Auths> {
    override fun from(input: Auths?): com.inseoul.data.model.Auths {
        return com.inseoul.data.model.Auths(
            time = input?.time,
            stretchingType = input?.stretchingType
        )
    }

    override fun to(output: com.inseoul.data.model.Auths?): Auths {
        return Auths(
            time = output?.time,
            stretchingType = output?.stretchingType
        )
    }
}

class GetStretchingDayNetworkDataMapper @Inject constructor() :
    Mapper<GetStretchingDayNetworkResponse, GetStretchingDayDataResponse> {
    override fun from(input: GetStretchingDayNetworkResponse?): GetStretchingDayDataResponse {
        val authsNetworkDataMapper = AuthsNetworkDataMapper()
        val authsList = listOf<Auths>()
        return GetStretchingDayDataResponse(
            authCount = input?.authCount,
            auths = authsNetworkDataMapper.fromList(authsList)
        )
    }

    override fun to(output: GetStretchingDayDataResponse?): GetStretchingDayNetworkResponse {
        val authsNetworkDataMapper = AuthsNetworkDataMapper()
        val authsList = listOf<com.inseoul.data.model.Auths>()
        return GetStretchingDayNetworkResponse(
            authCount = output?.authCount,
            auths = authsNetworkDataMapper.toList(authsList)
        )
    }
}