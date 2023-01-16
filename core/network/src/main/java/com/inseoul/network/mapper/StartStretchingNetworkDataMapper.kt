package com.inseoul.network.mapper

import com.example.common.Mapper
import com.inseoul.data.model.StartStretchingDataResponse
import com.inseoul.network.model.StartStretchingNetworkResponse
import javax.inject.Inject

class StartStretchingNetworkDataMapper @Inject constructor():
    Mapper<StartStretchingNetworkResponse, StartStretchingDataResponse> {
    override fun from(input: StartStretchingNetworkResponse?): StartStretchingDataResponse {
        return StartStretchingDataResponse(
            stretchingType = input?.stretchingType
        )
    }

    override fun to(output: StartStretchingDataResponse?): StartStretchingNetworkResponse {
        return StartStretchingNetworkResponse(
            stretchingType = output?.stretchingType
        )
    }
}