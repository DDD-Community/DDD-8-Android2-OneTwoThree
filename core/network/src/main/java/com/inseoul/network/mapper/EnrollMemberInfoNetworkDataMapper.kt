package com.inseoul.network.mapper

import com.example.common.Mapper
import com.inseoul.network.model.MemberId
import javax.inject.Inject

class EnrollMemberInfoNetworkDataMapper :
    Mapper<MemberId, com.inseoul.data.model.MemberId>{
    override fun from(input: MemberId?): com.inseoul.data.model.MemberId {
        return com.inseoul.data.model.MemberId(
            memberId = input?.memberId
        )
    }

    override fun to(output: com.inseoul.data.model.MemberId?): MemberId {
        return MemberId(
            memberId = output?.memberId
        )
    }


}