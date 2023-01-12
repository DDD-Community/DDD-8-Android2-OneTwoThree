package com.inseoul.network.mapper

import com.example.common.Mapper
import com.inseoul.network.model.MemberId
import javax.inject.Inject

class EnrollMemberInfoNetworkDataMapper @Inject constructor() :
    Mapper<MemberId, com.inseoul.data.model.MemberId>{
    override fun from(i: MemberId?): com.inseoul.data.model.MemberId {
        return com.inseoul.data.model.MemberId(
            memberId = i?.memberId
        )
    }

    override fun to(o: com.inseoul.data.model.MemberId?): MemberId {
        return MemberId(
            memberId = o?.memberId
        )
    }


}