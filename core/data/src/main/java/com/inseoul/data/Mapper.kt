package com.inseoul.data

import com.inseoul.data.model.AuthInfoData
import com.inseoul.domain.entity.AuthInfoData as DomainAuthInfoData

fun AuthInfoData?.toDomain(): DomainAuthInfoData {
    return this?.let {
        DomainAuthInfoData(
            memberId = it.memberId
        )
    } ?: DomainAuthInfoData()
}
