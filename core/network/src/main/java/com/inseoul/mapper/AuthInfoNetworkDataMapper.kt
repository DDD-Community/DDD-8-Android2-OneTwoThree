package com.inseoul.mapper

import com.example.common.Mapper
import com.inseoul.model.AuthInfoDataResponse
import com.inseoul.model.AuthInfoNetworkResponse
import javax.inject.Inject

class AuthInfoNetworkDataMapper @Inject constructor() :
    Mapper<AuthInfoNetworkResponse, AuthInfoDataResponse> {

    override fun from(i: AuthInfoNetworkResponse?): AuthInfoDataResponse {
        return AuthInfoDataResponse(
            data = i?.data
        )
    }

    override fun to(o: AuthInfoDataResponse?): AuthInfoNetworkResponse {
        return AuthInfoNetworkResponse(
            data = o?.data
        )
    }


}