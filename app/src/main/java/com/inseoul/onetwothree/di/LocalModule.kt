package com.inseoul.onetwothree.di

import android.content.Context
import com.inseoul.data.source.local.PrefsHelper
import com.inseoul.data.source.local.UserInfoLocalDataSource
import com.onetwothree.local.PrefsHelperImpl
import com.onetwothree.local.UserInfoLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {
    @Provides
    @Singleton
    fun provideSharedPreferences(@ApplicationContext applicationContext: Context): PrefsHelper =
        PrefsHelperImpl(applicationContext)

    @Provides
    @Singleton
    fun provideLocalUserInfoDataSource(prefsHelper: PrefsHelper): UserInfoLocalDataSource =
        UserInfoLocalDataSourceImpl(prefsHelper)
}
