package com.inseoul.network.mapper

import com.example.common.Mapper
import com.inseoul.network.model.GetAlarmData
import javax.inject.Inject

class GetAlarmNetworkDataMapper :
    Mapper<GetAlarmData, com.inseoul.data.model.GetAlarmData> {
    override fun from(input: GetAlarmData?): com.inseoul.data.model.GetAlarmData {
        return com.inseoul.data.model.GetAlarmData(
            alarmId = input?.alarmId,
            dayOfWeeks = input?.dayOfWeeks,
            excludeHoliday = input?.excludeHoliday,
            count = input?.count,
            pushTimeList = input?.pushTimeList
        )
    }

    override fun to(output: com.inseoul.data.model.GetAlarmData?): GetAlarmData {
        return GetAlarmData(
            alarmId = output?.alarmId,
            dayOfWeeks = output?.dayOfWeeks,
            excludeHoliday = output?.excludeHoliday,
            count = output?.count,
            pushTimeList = output?.pushTimeList
        )
    }

}