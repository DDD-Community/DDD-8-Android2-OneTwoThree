package com.inseoul.network.mapper

import com.example.common.Mapper
import com.inseoul.data.model.GetStretchingDayDataResponse
import com.inseoul.network.model.Auths
import com.inseoul.network.model.GetStretchingDayNetworkResponse
import javax.inject.Inject

class GetStretchingDayNetworkDataMapper @Inject constructor():
    Mapper<Auths, com.inseoul.data.model.Auths> {
    override fun from(i: Auths?): com.inseoul.data.model.Auths {
        return com.inseoul.data.model.Auths(
            time = i?.time,
            stretchingType = i?.stretchingType
        )
    }

    override fun to(o: com.inseoul.data.model.Auths?): Auths {
        return Auths(
            time = o?.time,
            stretchingType = o?.stretchingType
        )
    }

}