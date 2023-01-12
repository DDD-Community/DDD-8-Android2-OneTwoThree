package com.inseoul.data.mapper

import com.example.common.Mapper
import com.inseoul.data.model.GetStretchingDataResponse
import com.inseoul.domain.entity.GetStretchingEntityResponse
import javax.inject.Inject

class GetStretchingDataDomainMapper @Inject constructor() :
    Mapper<GetStretchingDataResponse, GetStretchingEntityResponse> {
    override fun from(i: GetStretchingDataResponse?): GetStretchingEntityResponse {
        return GetStretchingEntityResponse(
            stretchings = i?.stretchings
        )
    }

    override fun to(o: GetStretchingEntityResponse?): GetStretchingDataResponse {
        return GetStretchingDataResponse(
            stretchings = o?.stretchings
        )
    }
}