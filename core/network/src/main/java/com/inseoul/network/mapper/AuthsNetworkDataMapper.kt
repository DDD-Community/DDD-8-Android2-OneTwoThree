package com.inseoul.network.mapper

import com.example.common.Mapper
import com.inseoul.data.model.GetStretchingDayDataResponse
import com.inseoul.network.model.Auths
import com.inseoul.network.model.GetStretchingDayNetworkResponse
import javax.inject.Inject

class AuthsNetworkDataMapper @Inject constructor() :
    Mapper<Auths, com.inseoul.data.model.Auths> {
    override fun from(i: Auths?): com.inseoul.data.model.Auths {
        return com.inseoul.data.model.Auths(
            time = i?.time,
            stretchingType = i?.stretchingType
        )
    }

    override fun to(o: com.inseoul.data.model.Auths?): Auths {
        return Auths(
            time = o?.time,
            stretchingType = o?.stretchingType
        )
    }
}

class GetStretchingDayNetworkDataMapper @Inject constructor() :
    Mapper<GetStretchingDayNetworkResponse, GetStretchingDayDataResponse> {
    override fun from(i: GetStretchingDayNetworkResponse?): GetStretchingDayDataResponse {
        val authsNetworkDataMapper = AuthsNetworkDataMapper()
        val authsList = listOf<Auths>()
        return GetStretchingDayDataResponse(
            authCount = i?.authCount,
            auths = authsNetworkDataMapper.fromList(authsList)
        )
    }

    override fun to(o: GetStretchingDayDataResponse?): GetStretchingDayNetworkResponse {
        val authsNetworkDataMapper = AuthsNetworkDataMapper()
        val authsList = listOf<com.inseoul.data.model.Auths>()
        return GetStretchingDayNetworkResponse(
            authCount = o?.authCount,
            auths = authsNetworkDataMapper.toList(authsList)
        )
    }
}