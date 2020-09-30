package com.cat.blue.lambda

import java.util.*

fun String.toUp(): String {
    return this.toUpperCase(Locale.CHINA)
}

/**
 * 由于与String自带函数filter冲突，所以不得不使用一个新的名字
 */

//fun String.filter2(predicate: (Char) -> Boolean): String {
//    return this.filter {
//        predicate(it)
//    }
//}

fun String.filter(condition: (Char) -> Boolean): String {
    val sb = StringBuilder()
    forEach {
        if (condition(it)) {
            sb.append(it)
        }

    }
    return sb.toString()
}

fun String.mFilter(condition: (Char) -> Boolean): String {
    val sb = StringBuilder()
    forEach {
        if (condition(it)) sb.append(it)
    }
    return sb.toString()
}


fun main() {

    // println("abc2def3gh7".toUp())
    // println("abc2def3gh7".filter2 { Char->Char.isDigit() })
//    println("abc2def3gh7".filter2 {
//        it.isDigit()
//    })
    // println("abc2def3gh7".filter2 { Char->Char.isLetter() })
//    println("abc2def3gh7".filter2 {
//        it.isLetter()
//    })

    // val result = "abc2def3gh7".filter { it.isLetter() }
    // println(result)

//    val res = "abc2def3gh7".mFilter {
//        // it.isLetter()
//        it.isDigit()
//    }
//
//    println(res)


    val array = arrayOf("hello", "E", "world", "helloworldD", "welcome", "R")
    array.filter { it.contains("r") }.forEach { println(it) }
    println("-----------")

    array.filter { it.endsWith("D", true) }.map { it.toUpperCase() }.forEach { println(it) }
    println("-----------")

    array.filter {
        val fill = it.length > 3
        fill
    }.forEach { println(it) }
    println("-----------")

    array.filter {
        return@filter it.length > 4
    }

    array.filter(fun(i): Boolean = i.length > 3)

}