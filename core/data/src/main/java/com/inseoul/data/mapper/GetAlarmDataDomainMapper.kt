package com.inseoul.data.mapper

import com.example.common.Mapper
import com.inseoul.data.model.GetAlarmData
import javax.inject.Inject

class GetAlarmDataDomainMapper @Inject constructor() :
    Mapper<GetAlarmData, com.inseoul.domain.entity.GetAlarmData> {
    override fun from(input: GetAlarmData?): com.inseoul.domain.entity.GetAlarmData {
        return com.inseoul.domain.entity.GetAlarmData(
            alarmId = input?.alarmId,
            dayOfWeeks = input?.dayOfWeeks,
            excludeHoliday = input?.excludeHoliday,
            count = input?.count,
            pushTimeList = input?.pushTimeList
        )
    }

    override fun to(output: com.inseoul.domain.entity.GetAlarmData?): GetAlarmData {
        return GetAlarmData(
            alarmId = output?.alarmId,
            dayOfWeeks = output?.dayOfWeeks,
            excludeHoliday = output?.excludeHoliday,
            count = output?.count,
            pushTimeList = output?.pushTimeList
        )
    }
}