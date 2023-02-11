package com.inseoul.onetwothree.di

import android.app.Application
import com.inseoul.data.source.NetworkToLocalBridge
import com.inseoul.network.api.AlarmAPI
import com.inseoul.network.api.AuthAPI
import com.inseoul.network.api.MemberAPI
import com.inseoul.network.api.StretchingAPI
import com.inseoul.network.interceptor.OneTwoThreeInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    private const val CONNECT_TIMEOUT = 15L
    private const val WRITE_TIMEOUT = 15L
    private const val READ_TIMEOUT = 15L

    @Provides
    @Singleton
    fun provideCache(application: Application): Cache {
        return Cache(application.cacheDir, 10L * 1024 * 1024)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        cache: Cache,
        bridge: NetworkToLocalBridge
    ): OkHttpClient {
        return OkHttpClient.Builder().apply {
            cache(cache)
            connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
            writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
            readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            retryOnConnectionFailure(true)
            addInterceptor(provideOneTwoThreeInterceptor(bridge))
            addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
        }.build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://34.64.88.54:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    @Provides
    @Singleton
    fun provideMemberService(retrofit: Retrofit): MemberAPI {
        return retrofit.create(MemberAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideAlarmService(retrofit: Retrofit): AlarmAPI {
        return retrofit.create(AlarmAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideStretchingService(retrofit: Retrofit): StretchingAPI {
        return retrofit.create(StretchingAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideAuthService(retrofit: Retrofit): AuthAPI {
        return retrofit.create(AuthAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideOneTwoThreeInterceptor(bridge: NetworkToLocalBridge): OneTwoThreeInterceptor =
        OneTwoThreeInterceptor(bridge)
}
