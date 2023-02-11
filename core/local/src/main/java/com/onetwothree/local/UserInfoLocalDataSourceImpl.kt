package com.onetwothree.local

import com.inseoul.data.source.local.PrefsHelper
import com.inseoul.data.source.local.UserInfoLocalDataSource
import javax.inject.Inject

class UserInfoLocalDataSourceImpl @Inject constructor(
    private val prefsHelper: PrefsHelper
) : UserInfoLocalDataSource {
    override fun getMemberId(): String {
        return prefsHelper.memberId
    }
}
