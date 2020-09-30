package com.cat.blue.literal

import java.util.*

fun main() {

    // 写法1
    val literal1: Int.(other: Int) -> Int = { other -> this - other }
    println(198.literal1(10))
    // 188

    val literal3: String.(arg1: String, arg2: String, arg: String) -> String =
        { arg1, arg2, arg ->
            this + arg1.toUpperCase(Locale.CHINA) + arg2.toUpperCase(Locale.CHINA) + arg.toUpperCase(
                Locale.CHINA)
        }

    println("Kobe Bryant ".literal3("most ", "valuable ", "player "))
    // Kobe Bryant MOST VALUABLE PLAYER

    // 写法2
    val sum = fun Int.(other: Int): Int = this + other
    val sum2 = fun Int.(other: Int): Int { return this + other }
    println(100.sum(10))
    // 110
    println(178.sum2(10))
    // 188
}