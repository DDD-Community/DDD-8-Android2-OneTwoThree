package com.onetwothree.local

import android.content.Context
import androidx.core.content.edit
import com.example.common.Constants
import com.inseoul.data.source.local.PrefsHelper
import javax.inject.Inject

class PrefsHelperImpl @Inject constructor(applicationContext: Context) : PrefsHelper {
    private val prefs = applicationContext.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)

    override var memberId: String
        get() = prefs.getString(MEMBER_ID, Constants.EMPTY_STRING) ?: Constants.EMPTY_STRING
        @Synchronized
        set(value) {
            prefs.edit {
                putString(MEMBER_ID, value)
            }
        }

    companion object {
        const val FILE_NAME = "one_two_three"

        private const val MEMBER_ID = "member_id"
    }
}
