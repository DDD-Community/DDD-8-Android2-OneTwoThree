package com.inseoul.mapper

import com.example.common.Mapper
import com.inseoul.model.GetStretchingDayDataResponse
import com.inseoul.model.GetStretchingDayNetworkResponse
import javax.inject.Inject

class GetStretchingDayNetworkDataMapper @Inject constructor():
    Mapper<GetStretchingDayNetworkResponse, GetStretchingDayDataResponse> {
    override fun from(i: GetStretchingDayNetworkResponse?): GetStretchingDayDataResponse {
        return GetStretchingDayDataResponse(
            authCount = i?.authCount,
            auths = i?.auths
        )
    }

    override fun to(o: GetStretchingDayDataResponse?): GetStretchingDayNetworkResponse {
        return GetStretchingDayNetworkResponse(
            authCount = o?.authCount,
            auths = o?.auths
        )
    }
}