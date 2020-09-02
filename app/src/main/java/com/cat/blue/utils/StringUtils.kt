package com.cat.blue.utils

import android.text.TextUtils

//一下属性或方法属于顶层声明

var DalasCalf = "达拉斯小牛"

fun catIsEmpty(str: String): Boolean {
    return TextUtils.isEmpty(str)
}

fun catIsPhone(phone: String): Boolean {
    return phone.isNotEmpty() && phone.length == 11
}
