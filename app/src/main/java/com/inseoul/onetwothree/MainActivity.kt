package com.inseoul.onetwothree

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OneTwoThreeUI()
            getFCMToken()
        }
    }

    private fun getFCMToken(): String? {
        var token: String? = null
        FirebaseMessaging.getInstance().token.addOnCompleteListener { task ->
            if (!task.isSuccessful) {
                Log.w(TAG, "Fetching FCM registration token failed", task.exception)

            }

            // Get new FCM registration token
            token = task.result

            // Log and toast
            Log.d(TAG, "FCM Token is ${token}")
        }

        return token
    }

    companion object {
        val TAG = MainActivity::class.simpleName
    }
}
