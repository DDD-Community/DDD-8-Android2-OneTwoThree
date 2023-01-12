package com.inseoul.data.mapper

import com.example.common.Mapper
import com.inseoul.data.model.GetAlarmData
import javax.inject.Inject

class GetAlarmDataDomainMapper @Inject constructor() : Mapper<GetAlarmData, com.inseoul.domain.entity.GetAlarmData> {
    override fun from(i: GetAlarmData?): com.inseoul.domain.entity.GetAlarmData {
        return com.inseoul.domain.entity.GetAlarmData(
            alarmId = i?.alarmId,
            dayOfWeeks = i?.dayOfWeeks,
            excludeHoliday = i?.excludeHoliday,
            count = i?.count,
            pushTimeList = i?.pushTimeList
        )
    }

    override fun to(o: com.inseoul.domain.entity.GetAlarmData?): GetAlarmData {
        return GetAlarmData(
            alarmId = o?.alarmId,
            dayOfWeeks = o?.dayOfWeeks,
            excludeHoliday = o?.excludeHoliday,
            count = o?.count,
            pushTimeList = o?.pushTimeList
        )
    }
}