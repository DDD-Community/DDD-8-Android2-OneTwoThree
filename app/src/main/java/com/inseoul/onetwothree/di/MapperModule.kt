package com.inseoul.onetwothree.di

import com.example.common.Mapper
import com.inseoul.data.mapper.*
import com.inseoul.data.model.*
import com.inseoul.data.model.AuthInfoData
import com.inseoul.data.model.Auths
import com.inseoul.data.model.GetAlarmData
import com.inseoul.data.model.MemberId
import com.inseoul.data.model.StretchingAuthCount
import com.inseoul.domain.entity.GetStretchingEntityResponse
import com.inseoul.domain.entity.StartStretchingEntityResponse
import com.inseoul.network.mapper.*
import com.inseoul.network.model.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class MapperModule {

    /* remote -> data */

    @Binds
    abstract fun bindsAuthInfoNetworkDataMapper(
        mapper: AuthInfoNetworkDataMapper
    ): Mapper<AuthInfoNetworkResponse, AuthInfoDataResponse>

    @Binds
    abstract fun bindsEnrollMemberInfoNetworkDataMapper(
        mapper: EnrollMemberInfoNetworkDataMapper
    ): Mapper<EnrollMemberInfoNetworkResponse, EnrollMemberInfoDataResponse>

    @Binds
    abstract fun bindsGetAlarmNetworkDataMapper(
        mapper: GetAlarmNetworkDataMapper
    ): Mapper<GetAlarmNetworkResponse, GetAlarmDataResponse>

    @Binds
    abstract fun bindsGetStretchingAuthCountNetworkDataMapper(
        mapper: GetStretchingAuthCountNetworkDataMapper
    ): Mapper<GetStretchingAuthCountNetworkResponse, GetStretchingAuthCountDataResponse>

    @Binds
    abstract fun bindsGetStretchingDayNetworkDataMapper(
        mapper: GetStretchingDayNetworkDataMapper
    ): Mapper<GetStretchingDayNetworkResponse, GetStretchingDayDataResponse>

    @Binds
    abstract fun bindsGetStretchingNetworkDataMapper(
        mapper: GetStretchingNetworkDataMapper
    ): Mapper<GetStretchingNetworkResponse, GetStretchingDataResponse>

    @Binds
    abstract fun bindsStartStretchingNetworkDataMapper(
        mapper: StartStretchingNetworkDataMapper
    ): Mapper<StartStretchingNetworkResponse, StartStretchingDataResponse>

    /* data -> domain */
    @Binds
    abstract fun bindsAuthInfoDataDomainMapper(
        mapper: AuthInfoDataDomainMapper
    ): Mapper<AuthInfoData, com.inseoul.domain.entity.AuthInfoData>

    @Binds
    abstract fun bindsEnrollMemberInfoDataDomainMapper(
        mapper: EnrollMemberInfoDataDomainMapper
    ): Mapper<MemberId,com.inseoul.domain.entity.MemberId>

    @Binds
    abstract fun bindsGetAlarmDataDomainMapper(
        mapper: GetAlarmDataDomainMapper
    ): Mapper<GetAlarmData, com.inseoul.domain.entity.GetAlarmData>

    @Binds
    abstract fun bindsGetStretchingAuthCountDataDomainMapper(
        mapper: GetStretchingAuthCountDataDomainMapper
    ): Mapper<StretchingAuthCount, com.inseoul.domain.entity.StretchingAuthCount>

    @Binds
    abstract fun bindsGetStretchingDataDomainMapper(
        mapper: GetStretchingDataDomainMapper
    ): Mapper<GetStretchingDataResponse, GetStretchingEntityResponse>

    @Binds
    abstract fun bindsGetStretchingDayDataDomainMapper(
        mapper: GetStretchingDayDataDomainMapper
    ): Mapper<Auths, com.inseoul.domain.entity.Auths>

    @Binds
    abstract fun bindsStartStretchingDataDomainMapper(
        mapper: StartStretchingDataDomainMapper
    ): Mapper<StartStretchingDataResponse, StartStretchingEntityResponse>
}