package com.inseoul.network.mapper

import com.example.common.Constants
import com.inseoul.data.model.AuthInfoData
import com.inseoul.network.model.EnrollMemberInfoNetworkResponse

fun EnrollMemberInfoNetworkResponse?.toData(): AuthInfoData {
    return this?.data?.let {
        AuthInfoData(
            memberId = it.memberId ?: 0,
            nickname = Constants.EMPTY_STRING
        )
    } ?: AuthInfoData()
}
