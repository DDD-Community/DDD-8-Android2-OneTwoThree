package com.inseoul.data.mapper

import com.example.common.Mapper
import com.inseoul.data.model.MemberId
import javax.inject.Inject

class EnrollMemberInfoDataDomainMapper @Inject constructor() :
    Mapper<MemberId,com.inseoul.domain.entity.MemberId> {
    override fun from(i: MemberId?): com.inseoul.domain.entity.MemberId {
        return com.inseoul.domain.entity.MemberId(
            memberId = i?.memberId
        )
    }

    override fun to(o: com.inseoul.domain.entity.MemberId?): MemberId {
        return MemberId(
            memberId = o?.memberId
        )
    }
}