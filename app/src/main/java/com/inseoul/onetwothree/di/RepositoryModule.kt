package com.inseoul.onetwothree.di

import com.inseoul.data.repository.RepositoryImpl
import com.inseoul.data.repository.UserInfoRepositoryImpl
import com.inseoul.data.source.NetworkDataSource
import com.inseoul.data.source.NetworkToLocalBridge
import com.inseoul.data.source.NetworkToLocalBridgeImpl
import com.inseoul.data.source.UserInfoDataSource
import com.inseoul.data.source.local.PrefsHelper
import com.inseoul.data.source.local.UserInfoLocalDataSource
import com.inseoul.domain.repository.Repository
import com.inseoul.domain.repository.UserInfoRepository
import com.inseoul.network.source.NetworkDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindsNetworkDataSource(
        networkDataSourceImpl: NetworkDataSourceImpl
    ): NetworkDataSource

    @Binds
    abstract fun bindsRepository(
        repositoryImpl: RepositoryImpl
    ): Repository

//    @Binds
//    abstract fun bindsUserInfoRepository(
//        userInfoRepositoryImpl: UserInfoRepositoryImpl
//    ): UserInfoRepository
}


@Module
@InstallIn(SingletonComponent::class)
object NewRepositoryModule {
    @Provides
    @Singleton
    fun provideUserInfoRepository(
        userInfoDataSource: UserInfoDataSource,
        prefsHelper: PrefsHelper
    ): UserInfoRepository = UserInfoRepositoryImpl(userInfoDataSource, prefsHelper)

    @Provides
    @Singleton
    fun provideNetworkToLocalBridge(
        userInfoLocalDataSource: UserInfoLocalDataSource
    ): NetworkToLocalBridge = NetworkToLocalBridgeImpl(userInfoLocalDataSource)
}
