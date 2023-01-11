package com.inseoul.mapper

import com.example.common.Mapper
import com.inseoul.model.GetAlarmData
import com.inseoul.model.GetAlarmNetworkData
import javax.inject.Inject

// list 단위 list 내부 단위..? 확인 필요ㅕ
class GetAlarmNetworkDataMapper @Inject constructor() : Mapper<GetAlarmNetworkData, GetAlarmData> {
    override fun from(i: GetAlarmNetworkData?): GetAlarmData {
        return GetAlarmData(
            alarmId = i?.alarmId,
            dayOfWeeks = i?.dayOfWeeks,
            excludeHoliday = i?.excludeHoliday,
            count = i?.count,
            pushTimeList = i?.pushTimeList
        )
    }

    override fun to(o: GetAlarmData?): GetAlarmNetworkData {
        return GetAlarmNetworkData(
            alarmId = o?.alarmId,
            dayOfWeeks = o?.dayOfWeeks,
            excludeHoliday = o?.excludeHoliday,
            count = o?.count,
            pushTimeList = o?.pushTimeList
        )
    }

}