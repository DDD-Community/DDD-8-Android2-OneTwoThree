package com.inseoul.onetwothree.di

import com.inseoul.data.source.UserInfoDataSource
import com.inseoul.network.api.MemberAPI
import com.inseoul.network.source.UserInfoDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkDataSourceModule {
    @Provides
    @Singleton
    fun provideUserInfoDataSource(memberAPI: MemberAPI): UserInfoDataSource =
        UserInfoDataSourceImpl(memberAPI)
}
