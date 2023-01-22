package com.inseoul.data.mapper

import com.example.common.Mapper
import com.inseoul.data.model.GetStretchingDataResponse
import com.inseoul.domain.entity.GetStretchingEntityResponse
import javax.inject.Inject

class GetStretchingDataDomainMapper @Inject constructor() :
    Mapper<GetStretchingDataResponse, GetStretchingEntityResponse> {
    override fun from(input: GetStretchingDataResponse?): GetStretchingEntityResponse {
        return GetStretchingEntityResponse(
            stretchings = input?.stretchings
        )
    }

    override fun to(output: GetStretchingEntityResponse?): GetStretchingDataResponse {
        return GetStretchingDataResponse(
            stretchings = output?.stretchings
        )
    }
}