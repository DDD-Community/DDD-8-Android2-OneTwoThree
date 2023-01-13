package com.inseoul.network.mapper

import com.example.common.Mapper
import com.inseoul.network.model.StretchingAuthCount
import javax.inject.Inject

class GetStretchingAuthCountNetworkDataMapper @Inject constructor():
    Mapper<StretchingAuthCount, com.inseoul.data.model.StretchingAuthCount> {
    override fun from(i: StretchingAuthCount?): com.inseoul.data.model.StretchingAuthCount {
        return com.inseoul.data.model.StretchingAuthCount(
            stretchingAuthCount = i?.stretchingAuthCount
        )
    }

    override fun to(o: com.inseoul.data.model.StretchingAuthCount?): StretchingAuthCount {
        return StretchingAuthCount(
            stretchingAuthCount = o?.stretchingAuthCount
        )
    }

}