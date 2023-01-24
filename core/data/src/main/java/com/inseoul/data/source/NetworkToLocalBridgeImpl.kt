package com.inseoul.data.source

import com.inseoul.data.source.local.UserInfoLocalDataSource
import javax.inject.Inject

class NetworkToLocalBridgeImpl @Inject constructor(
    private val userInfoLocalDataSource: UserInfoLocalDataSource
) : NetworkToLocalBridge {
    override fun getMemberId(): String {
        return userInfoLocalDataSource.getMemberId()
    }
}
