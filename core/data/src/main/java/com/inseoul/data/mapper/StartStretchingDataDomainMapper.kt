package com.inseoul.data.mapper

import com.example.common.Mapper
import com.inseoul.data.model.StartStretchingDataResponse
import com.inseoul.domain.entity.StartStretchingEntityResponse
import javax.inject.Inject

class StartStretchingDataDomainMapper @Inject constructor() :
    Mapper<StartStretchingDataResponse, StartStretchingEntityResponse> {
    override fun from(i: StartStretchingDataResponse?): StartStretchingEntityResponse {
        return StartStretchingEntityResponse(
            stretchingType = i?.stretchingType
        )
    }

    override fun to(o: StartStretchingEntityResponse?): StartStretchingDataResponse {
        return StartStretchingDataResponse(
            stretchingType = o?.stretchingType
        )
    }
}