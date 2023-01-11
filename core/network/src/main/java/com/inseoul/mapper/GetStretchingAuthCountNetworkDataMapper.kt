package com.inseoul.mapper

import com.example.common.Mapper
import com.inseoul.model.GetStretchingAuthCountDataResponse
import com.inseoul.model.GetStretchingAuthCountNetworkResponse
import javax.inject.Inject

class GetStretchingAuthCountNetworkDataMapper @Inject constructor():
    Mapper<GetStretchingAuthCountNetworkResponse, GetStretchingAuthCountDataResponse> {
    override fun from(i: GetStretchingAuthCountNetworkResponse?): GetStretchingAuthCountDataResponse {
        return GetStretchingAuthCountDataResponse(
            data = i?.data
        )
    }

    override fun to(o: GetStretchingAuthCountDataResponse?): GetStretchingAuthCountNetworkResponse {
        return GetStretchingAuthCountNetworkResponse(
            data = o?.data
        )
    }
}