package com.inseoul.onetwothree.di

import com.example.common.Mapper
import com.inseoul.mapper.*
import com.inseoul.model.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class MapperModule {

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
    ): Mapper<GetAlarmNetworkData, GetAlarmData>

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
}