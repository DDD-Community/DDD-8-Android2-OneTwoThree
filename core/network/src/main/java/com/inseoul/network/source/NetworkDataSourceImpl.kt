package com.inseoul.network.source

import com.inseoul.data.model.*
import com.inseoul.data.source.NetworkDataSource
import com.inseoul.network.api.AlarmAPI
import com.inseoul.network.api.AuthAPI
import com.inseoul.network.api.MemberAPI
import com.inseoul.network.api.StretchingAPI
import com.inseoul.network.mapper.*
import javax.inject.Inject

class NetworkDataSourceImpl @Inject constructor(
    private val memberAPI: MemberAPI,
    private val alarmAPI: AlarmAPI,
    private val stretchingAPI: StretchingAPI,
    private val authAPI: AuthAPI,
    private val enrollMemberInfoNetworkDataMapper: EnrollMemberInfoNetworkDataMapper,
    private val getAlarmNetworkDataMapper: GetAlarmNetworkDataMapper,
    private val getStretchingAuthCountNetworkDataMapper: GetStretchingAuthCountNetworkDataMapper,
    private val authsNetworkDataMapper: AuthsNetworkDataMapper,
    private val getStretchingNetworkDataMapper: GetStretchingNetworkDataMapper,
    private val startStretchingNetworkDataMapper: StartStretchingNetworkDataMapper,
    private val getStretchingDayNetworkDataMapper: GetStretchingDayNetworkDataMapper
) : NetworkDataSource {
    override suspend fun enrollMemberInfo(
        nickname: String,
        firebaseToken: String
    ): MemberId {
        val networkDataList = memberAPI.enrollMemberInfo(
            nickname, firebaseToken
        )
        val networkData = networkDataList.data
        return enrollMemberInfoNetworkDataMapper.from(networkData)
    }

    override suspend fun changeNickname(onetwothreeMemberId: Int, nickname: String) {
        val networkData = memberAPI.changeNickname(
            onetwothreeMemberId, nickname
        )
        return networkData
    }

    override suspend fun addAlarm(
        onetwothreeMemberId: Int,
        dayOfWeeks: List<String>,
        excludeHoliday: Boolean,
        startTime: String,
        endTime: String,
        count: Int
    ) {
        val networkData = alarmAPI.addAlarm(
            onetwothreeMemberId, dayOfWeeks, excludeHoliday, startTime, endTime, count
        )
        return networkData
    }

    override suspend fun deleteAlarm(alarm_id: Int?) {
        val networkData = alarmAPI.deleteAlarm(alarm_id)
        return networkData
    }

    override suspend fun getAlarm(onetwothreeMemberId: Int): List<GetAlarmData> {
        val networkDataList = alarmAPI.getAlarm(onetwothreeMemberId)
        val networkData = networkDataList.data
        return getAlarmNetworkDataMapper.fromList(networkData)
    }

    override suspend fun startStretching(): StartStretchingDataResponse {
        val networkData = stretchingAPI.startStretching()
        return startStretchingNetworkDataMapper.from(networkData)
    }

    override suspend fun getStretching(): GetStretchingDataResponse {
        val networkData = stretchingAPI.getStretching()
        return getStretchingNetworkDataMapper.from(networkData)
    }

    // todo 수정
    override suspend fun getStretchingMonth(onetwothreeMemberId: Int, year: Int?, month: Int?) {

    }

    override suspend fun getStretchingDay(
        onetwothreeMemberId: Int,
        year: Int?,
        month: Int?,
        day: Int?
    ): GetStretchingDayDataResponse {
        val networkDataList = authAPI.getStretchingDay(
            onetwothreeMemberId, year, month, day
        )
        return getStretchingDayNetworkDataMapper.from(networkDataList)
        //val networkData = networkDataList.auths
        //return getStretchingDayNetworkDataMapper.fromList(networkData)
    }

    override suspend fun getStretchingCount(
        onetwothree_member_id: Int,
        stretchingType: String
    ): StretchingAuthCount {
        val networkDataList = authAPI.getStretchingAuthCount(
            onetwothree_member_id, stretchingType
        )
        val networkData = networkDataList.data
        return getStretchingAuthCountNetworkDataMapper.from(networkData)
    }

}
