package com.inseoul.network.mapper

import com.example.common.Mapper
import com.inseoul.data.model.StartStretchingDataResponse
import com.inseoul.network.model.StartStretchingNetworkResponse
import javax.inject.Inject

class StartStretchingNetworkDataMapper @Inject constructor():
    Mapper<StartStretchingNetworkResponse, StartStretchingDataResponse> {
    override fun from(i: StartStretchingNetworkResponse?): StartStretchingDataResponse {
        return StartStretchingDataResponse(
            stretchingType = i?.stretchingType
        )
    }

    override fun to(o: StartStretchingDataResponse?): StartStretchingNetworkResponse {
        return StartStretchingNetworkResponse(
            stretchingType = o?.stretchingType
        )
    }
}