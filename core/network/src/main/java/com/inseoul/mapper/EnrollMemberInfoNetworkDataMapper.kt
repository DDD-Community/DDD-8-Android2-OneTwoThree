package com.inseoul.mapper

import com.example.common.Mapper
import com.inseoul.model.EnrollMemberInfoDataResponse
import com.inseoul.model.EnrollMemberInfoNetworkResponse
import javax.inject.Inject

class EnrollMemberInfoNetworkDataMapper @Inject constructor() :
    Mapper<EnrollMemberInfoNetworkResponse, EnrollMemberInfoDataResponse>{
    override fun from(i: EnrollMemberInfoNetworkResponse?): EnrollMemberInfoDataResponse {
        return EnrollMemberInfoDataResponse(
            data = i?.data
        )
    }

    override fun to(o: EnrollMemberInfoDataResponse?): EnrollMemberInfoNetworkResponse {
        return EnrollMemberInfoNetworkResponse(
            data = o?.data
        )
    }
}