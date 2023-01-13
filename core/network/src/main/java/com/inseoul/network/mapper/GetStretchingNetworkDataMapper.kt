package com.inseoul.network.mapper

import com.example.common.Mapper
import com.inseoul.data.model.GetStretchingDataResponse
import com.inseoul.network.model.GetStretchingNetworkResponse
import javax.inject.Inject

class GetStretchingNetworkDataMapper @Inject constructor():
    Mapper<GetStretchingNetworkResponse, GetStretchingDataResponse> {
    override fun from(i: GetStretchingNetworkResponse?): GetStretchingDataResponse {
        return GetStretchingDataResponse(
            stretchings = i?.stretchings
        )
    }

    override fun to(o: GetStretchingDataResponse?): GetStretchingNetworkResponse {
        return GetStretchingNetworkResponse(
            stretchings = o?.stretchings
        )
    }
}