package com.inseoul.data.mapper

import com.example.common.Mapper
import com.inseoul.data.model.MemberId
import javax.inject.Inject

class EnrollMemberInfoDataDomainMapper @Inject constructor() :
    Mapper<MemberId,com.inseoul.domain.entity.MemberId> {
    override fun from(input: MemberId?): com.inseoul.domain.entity.MemberId {
        return com.inseoul.domain.entity.MemberId(
            memberId = input?.memberId
        )
    }

    override fun to(output: com.inseoul.domain.entity.MemberId?): MemberId {
        return MemberId(
            memberId = output?.memberId
        )
    }
}