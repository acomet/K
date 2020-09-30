package com.cat.blue.strucdeclarations

/**
 * 解构声明
 */
fun main() {
    val (code, message) = getHttpResult()
    println("code = $code , message = $message")

    val (arg1, arg2) = getHttpResult2()
    println("arg1 = $arg1 , arg2 = $arg2")
}

data class HttpResult(val code: Int, val message: String)

fun getHttpResult(): HttpResult {
    return HttpResult(200, "network error")
}

fun getHttpResult2(): Pair<Int, String> {
    return Pair(200, "oops error")
}
