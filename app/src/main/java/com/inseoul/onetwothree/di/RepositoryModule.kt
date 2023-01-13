package com.inseoul.onetwothree.di

import com.inseoul.data.repository.RepositoryImpl
import com.inseoul.data.source.NetworkDataSource
import com.inseoul.domain.repository.Repository
import com.inseoul.network.source.NetworkDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

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
}