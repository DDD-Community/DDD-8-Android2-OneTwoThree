package com.inseoul.source

import com.inseoul.api.StretchingAPI
import com.inseoul.mapper.*
import com.inseoul.model.*
import retrofit2.Response
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
    ): EnrollMemberInfoDataResponse {
        val networkData = stretchingAPI.enrollMemberInfo(
            nickname, firebaseToken
        )
        return enrollMemberInfoNetworkDataMapper.from(networkData)
    }

    override suspend fun getMemberInfo(firebase_token: String): AuthInfoDataResponse {
        val networkData = stretchingAPI.getMemberInfo(firebase_token)
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

    override suspend fun getAlarm(onetwothreeMemberId: Int): GetAlarmDataResponse {
        val networkData = stretchingAPI.getAlarm(onetwothreeMemberId)
        return getAlarmNetworkDataMapper.from(networkData)
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
        val networkData = stretchingAPI.getStretchingDay(
            onetwothreeMemberId, year, month, day
        )
        return getStretchingDayNetworkDataMapper.from(networkData)
    }

    override suspend fun getStretchingCount(
        onetwothree_member_id: Int,
        stretchingType: String
    ): GetStretchingAuthCountDataResponse {
        val networkData = stretchingAPI.getStretchingAuthCount(
            onetwothree_member_id, stretchingType
        )
        return getStretchingAuthCountNetworkDataMapper.from(networkData)
    }

}