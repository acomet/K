package com.cat.blue.lambda

fun main() {
    // 1
//    nothing(18) {
//
//    }

    // 2
//    alpha0(9) {
//        println("方法参数有lambda，lambda有参数，无返回值，方法整体没有返回值。结果是$it")
//    }

    // 3
    alpha1(100) {
        println(it)
        return@alpha1 "origin = $it , and result is 'HELLO WORLD'"
    }


    beta(8, 9) { a, b ->
        println("hello")
        println("world")
        println("hi")
        a * b
    }
}

// 方法参数有lambda，lambda无参数，无返回值， 方法整体没有返回值
fun nothing(x: Int, predicate: () -> Unit) {
    println("nothing原始x=$x")
    predicate.invoke()
}

// 方法参数有lambda，lambda有参数，无返回值， 方法整体没有返回值
fun alpha0(x: Int, callback: (Int) -> Unit) {
    println("alpha0原始x=$x")
    val result = x + 100 + 200 + 300
    callback(result)
}

// 方法参数有lambda，lambda有参数，有返回值， 方法整体没有返回值
fun alpha1(x: Int, predicate: (Int) -> String) {
    println("alpha1原始x=$x")
    val result = x + 100 + 200 + 300
    predicate.invoke(result)
}

fun beta(x: Int, y: Int, predicate: (Int, Int) -> Int) {
    println("beta 原始x=$x")
    predicate(x, y)
}