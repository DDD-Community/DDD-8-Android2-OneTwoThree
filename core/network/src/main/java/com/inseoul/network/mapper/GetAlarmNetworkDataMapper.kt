package com.inseoul.network.mapper

import com.example.common.Mapper
import com.inseoul.data.model.GetAlarmDataResponse
import com.inseoul.network.model.GetAlarmData
import com.inseoul.network.model.GetAlarmNetworkResponse
import javax.inject.Inject

// list 단위 list 내부 단위 확인 필요ㅕ
class GetAlarmNetworkDataMapper @Inject constructor() :
    Mapper<GetAlarmData, com.inseoul.data.model.GetAlarmData> {
    override fun from(i: GetAlarmData?): com.inseoul.data.model.GetAlarmData {
        return com.inseoul.data.model.GetAlarmData(
            alarmId = i?.alarmId,
            dayOfWeeks = i?.dayOfWeeks,
            excludeHoliday = i?.excludeHoliday,
            count = i?.count,
            pushTimeList = i?.pushTimeList
        )
    }

    override fun to(o: com.inseoul.data.model.GetAlarmData?): GetAlarmData {
        return GetAlarmData(
            alarmId = o?.alarmId,
            dayOfWeeks = o?.dayOfWeeks,
            excludeHoliday = o?.excludeHoliday,
            count = o?.count,
            pushTimeList = o?.pushTimeList
        )
    }

}