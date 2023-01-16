package com.inseoul.data.mapper

import com.example.common.Mapper
import com.inseoul.data.model.StretchingAuthCount
import javax.inject.Inject

class GetStretchingAuthCountDataDomainMapper @Inject constructor() :
    Mapper<StretchingAuthCount, com.inseoul.domain.entity.StretchingAuthCount> {
    override fun from(input: StretchingAuthCount?): com.inseoul.domain.entity.StretchingAuthCount {
        return com.inseoul.domain.entity.StretchingAuthCount(
            stretchingAuthCount = input?.stretchingAuthCount
        )
    }

    override fun to(output: com.inseoul.domain.entity.StretchingAuthCount?): StretchingAuthCount {
        return StretchingAuthCount(
            stretchingAuthCount = output?.stretchingAuthCount
        )
    }
}