package com.inseoul.data.repository

import com.inseoul.data.mapper.*
import com.inseoul.data.source.NetworkDataSource
import com.inseoul.domain.entity.*
import com.inseoul.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val networkDataSource: NetworkDataSource,
    private val authInfoDataDomainMapper: AuthInfoDataDomainMapper,
    private val enrollMemberInfoDataDomainMapper: EnrollMemberInfoDataDomainMapper,
    private val getAlarmDataDomainMapper: GetAlarmDataDomainMapper,
    private val getStretchingAuthCountDataDomainMapper: GetStretchingAuthCountDataDomainMapper,
    private val getStretchingDataDomainMapper: GetStretchingDataDomainMapper,
    private val getStretchingDayDataDomainMapper: GetStretchingDayDataDomainMapper,
    private val startStretchingDataDomainMapper: StartStretchingDataDomainMapper
) : Repository {

    override suspend fun getMemberInfo(firebase_token: String): Flow<AuthInfoData> {
        return flow {
            val dataList = networkDataSource.getMemberInfo(firebase_token)
            emit(authInfoDataDomainMapper.from(dataList))
        }
    }

    override suspend fun changeNickname(onetwothreeMemberId: Int, nickname: String) {
        TODO("Not yet implemented")
    }

    override suspend fun addAlarm(
        onetwothreeMemberId: Int,
        dayOfWeeks: List<String>,
        excludeHoliday: Boolean,
        startTime: String,
        endTime: String,
        count: Int
    ) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteAlarm(alarm_id: Int?) {
        TODO("Not yet implemented")
    }

    override suspend fun getAlarm(onetwothreeMemberId: Int): Flow<List<GetAlarmData>> {
        return flow {
            val dataList = networkDataSource.getAlarm(onetwothreeMemberId)
            emit(getAlarmDataDomainMapper.fromList(dataList))
        }
    }

    override suspend fun startStretching(): Flow<StartStretchingEntityResponse> {
        return flow {
            val dataList = networkDataSource.startStretching()
            emit(startStretchingDataDomainMapper.from(dataList))
        }
    }

    override suspend fun getStretching(): Flow<GetStretchingEntityResponse> {
        return flow {
            val dataList = networkDataSource.getStretching()
            emit(getStretchingDataDomainMapper.from(dataList))
        }
    }

    override suspend fun getStretchingMonth(onetwothreeMemberId: Int, year: Int?, month: Int?) {
        TODO("Not yet implemented")
    }

    override suspend fun getStretchingDay(
        onetwothreeMemberId: Int,
        year: Int?,
        month: Int?,
        day: Int?
    ): Flow<List<Auths>> {
        return flow {
            val dataList = networkDataSource.getStretchingDay(onetwothreeMemberId, year, month, day)
            emit(getStretchingDayDataDomainMapper.fromList(dataList))
        }
    }

    override suspend fun getStretchingCount(
        onetwothree_member_id: Int,
        stretchingType: String
    ): Flow<StretchingAuthCount> {
        return flow {
            val dataList = networkDataSource.getStretchingCount(onetwothree_member_id, stretchingType)
            emit(getStretchingAuthCountDataDomainMapper.from(dataList))
        }
    }

    override suspend fun enrollMemberInfo(
        nickname: String,
        firebaseToken: String
    ): Flow<MemberId> {
        return flow {
            val data = networkDataSource.enrollMemberInfo(nickname, firebaseToken)
            emit(enrollMemberInfoDataDomainMapper.from(data))
        }
    }


}