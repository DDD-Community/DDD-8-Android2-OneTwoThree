package com.inseoul.network.source

import com.inseoul.network.api.StretchingAPI
import com.inseoul.data.model.*
import com.inseoul.data.source.NetworkDataSource
import com.inseoul.network.mapper.*
import javax.inject.Inject

class NetworkDataSourceImpl @Inject constructor(
    private val stretchingAPI: StretchingAPI,
    private val authInfoNetworkDataMapper: AuthInfoNetworkDataMapper,
    private val enrollMemberInfoNetworkDataMapper: EnrollMemberInfoNetworkDataMapper,
    private val getAlarmNetworkDataMapper: GetAlarmNetworkDataMapper,
    private val getStretchingAuthCountNetworkDataMapper: GetStretchingAuthCountNetworkDataMapper,
    private val getStretchingDayNetworkDataMapper: GetStretchingDayNetworkDataMapper,
    private val getStretchingNetworkDataMapper: GetStretchingNetworkDataMapper,
    private val startStretchingNetworkDataMapper: StartStretchingNetworkDataMapper
) : NetworkDataSource {
    override suspend fun enrollMemberInfo(
        nickname: String,
        firebaseToken: String
    ): MemberId {
        val networkDataList = stretchingAPI.enrollMemberInfo(
            nickname, firebaseToken
        )
        val networkData = networkDataList.data
        return enrollMemberInfoNetworkDataMapper.from(networkData)
    }

    override suspend fun getMemberInfo(firebase_token: String): AuthInfoData {
        val networkDataList = stretchingAPI.getMemberInfo(firebase_token)
        val networkData = networkDataList.data
        return authInfoNetworkDataMapper.from(networkData)
    }

    override suspend fun changeNickname(onetwothreeMemberId: Int, nickname: String) {
        val networkData = stretchingAPI.changeNickname(
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
        val networkData = stretchingAPI.addAlarm(
            onetwothreeMemberId, dayOfWeeks, excludeHoliday, startTime, endTime, count
        )
        return networkData
    }

    override suspend fun deleteAlarm(alarm_id: Int?) {
        val networkData = stretchingAPI.deleteAlarm(alarm_id)
        return networkData
    }

    override suspend fun getAlarm(onetwothreeMemberId: Int): List<GetAlarmData> {
        val networkDataList = stretchingAPI.getAlarm(onetwothreeMemberId)
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

    // todo  값 추가 필여
    override suspend fun getStretchingDay(
        onetwothreeMemberId: Int,
        year: Int?,
        month: Int?,
        day: Int?
    ): List<Auths> {
        val networkDataList = stretchingAPI.getStretchingDay(
            onetwothreeMemberId, year, month, day
        )
        val networkData = networkDataList.auths
        return getStretchingDayNetworkDataMapper.fromList(networkData)
    }

    override suspend fun getStretchingCount(
        onetwothree_member_id: Int,
        stretchingType: String
    ): StretchingAuthCount {
        val networkDataList = stretchingAPI.getStretchingAuthCount(
            onetwothree_member_id, stretchingType
        )
        val networkData = networkDataList.data
        return getStretchingAuthCountNetworkDataMapper.from(networkData)
    }

}