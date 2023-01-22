package com.inseoul.network.mapper

import com.example.common.Mapper
import com.inseoul.data.model.GetStretchingDataResponse
import com.inseoul.network.model.GetStretchingNetworkResponse
import javax.inject.Inject

class GetStretchingNetworkDataMapper :
    Mapper<GetStretchingNetworkResponse, GetStretchingDataResponse> {
    override fun from(input: GetStretchingNetworkResponse?): GetStretchingDataResponse {
        return GetStretchingDataResponse(
            stretchings = input?.stretchings
        )
    }

    override fun to(output: GetStretchingDataResponse?): GetStretchingNetworkResponse {
        return GetStretchingNetworkResponse(
            stretchings = output?.stretchings
        )
    }
}