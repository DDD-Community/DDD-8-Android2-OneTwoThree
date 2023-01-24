package com.inseoul.network.interceptor

import com.inseoul.data.source.NetworkToLocalBridge
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class OneTwoThreeInterceptor @Inject constructor(
    private val networkToLocalBridge: NetworkToLocalBridge
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val memberId = networkToLocalBridge.getMemberId()
        val request = chain.request().newBuilder()

        if (memberId.isNotEmpty()) {
            request.addHeader(HEADER_MEMBER_ID, memberId)
        }

        return chain.proceed(request.build())
    }

    companion object {
        private const val HEADER_MEMBER_ID = "onetwothree-member-id"
    }
}
