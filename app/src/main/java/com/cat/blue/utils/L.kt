package com.cat.blue.utils

import android.text.TextUtils
import android.util.Log

object L {

    private const val TAG = "-----R-----"

    fun i(msg: String?) {
        if (!TextUtils.isEmpty(msg)) {
            Log.i(TAG, msg!!)
        }
    }

    fun d(msg: String?) {
        if (!TextUtils.isEmpty(msg)) {
            Log.d(TAG, msg!!)
        }
    }
}