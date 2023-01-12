package com.inseoul.data.mapper

import com.example.common.Mapper
import com.inseoul.data.model.StretchingAuthCount
import javax.inject.Inject

class GetStretchingAuthCountDataDomainMapper @Inject constructor() : Mapper<StretchingAuthCount, com.inseoul.domain.entity.StretchingAuthCount> {
    override fun from(i: StretchingAuthCount?): com.inseoul.domain.entity.StretchingAuthCount {
        return com.inseoul.domain.entity.StretchingAuthCount(
            stretchingAuthCount = i?.stretchingAuthCount
        )
    }

    override fun to(o: com.inseoul.domain.entity.StretchingAuthCount?): StretchingAuthCount {
        return StretchingAuthCount(
            stretchingAuthCount = o?.stretchingAuthCount
        )
    }
}