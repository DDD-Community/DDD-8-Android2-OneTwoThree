package com.inseoul.data.mapper

import com.example.common.Mapper
import com.inseoul.data.model.Auths
import com.inseoul.data.model.GetStretchingDayDataResponse
import javax.inject.Inject

class GetStretchingDayDataDomainMapper @Inject constructor() :
    Mapper<Auths, com.inseoul.domain.entity.Auths> {
    override fun from(i: Auths?): com.inseoul.domain.entity.Auths {
        return com.inseoul.domain.entity.Auths(
            time = i?.time,
            stretchingType = i?.stretchingType
        )
    }

    override fun to(o: com.inseoul.domain.entity.Auths?): Auths {
        return Auths(
            time = o?.time,
            stretchingType = o?.stretchingType
        )
    }
}