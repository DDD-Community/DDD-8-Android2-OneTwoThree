package com.inseoul.data.mapper

import com.example.common.Mapper
import com.inseoul.data.model.StartStretchingDataResponse
import com.inseoul.domain.entity.StartStretchingEntityResponse
import javax.inject.Inject

class StartStretchingDataDomainMapper @Inject constructor() :
    Mapper<StartStretchingDataResponse, StartStretchingEntityResponse> {
    override fun from(input: StartStretchingDataResponse?): StartStretchingEntityResponse {
        return StartStretchingEntityResponse(
            stretchingType = input?.stretchingType
        )
    }

    override fun to(output: StartStretchingEntityResponse?): StartStretchingDataResponse {
        return StartStretchingDataResponse(
            stretchingType = output?.stretchingType
        )
    }
}