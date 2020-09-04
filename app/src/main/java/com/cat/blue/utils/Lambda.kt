package com.cat.blue.utils

import java.util.*

fun main() {
//    println(ok(100))
    println(alpha(::a, 5))
//    println(alpha(::b, 8))
//    println(alpha(::c, 3))


    // 把一个函数赋值成一个变量使用 :: ， 此后fTest0就是一个对象，和test1()具有相同功能的对象
    val fTest0 = ::test1
    // 对象再赋值给另外的对象
    val fTest1 = fTest0
//    println(fTest0(9))
//    println(fTest1(20))

    // 实际上是调用了这个函数类型的invoke()方法
    val result0 = (::test1)(25)
    // 函数类型的对象有invoke()这个方法
    val result1 = ::test1.invoke(6)
//    println(result0)
//    println(result1)

    // 实际上是调用了这个函数类型的invoke()方法
    val result2 = (::test2)(3, 4, 5)
    val result3 = (::test2).invoke(2, 3, 4)
//    println(result2)
//    println(result3)

    // 匿名函数形式
    listener.setOnAListener(fun(x: Int) {
        println(x)
    })

    // 匿名函数可以写成lambda表达式
    listener.setOnAListener({ it: Int ->

    })
    listener.set2ArgumentListener({ x: Int, y: String, z: Boolean ->

    })
    // 如果函数的最后一个参数是lambda表达式的话，那么lambda表达式还可以写在函数参数体()的外面，如
    listener.setOnAListener() { it: Int ->

    }

    // 如果lambda表达式是函数的最后一个参数，那么还可以把()去掉，如
    listener.setOnAListener { it: Int ->

    }

    // 如果这个lambda表达式是单参数的，那么还可以把参数去掉，那么怎么使用那个单参数呢， 如果不写，系统内部是 ‘it’
    listener.setOnAListener {
        println(it)
    }

    listener.setOnAListener { }

    testFun()
}

fun testFun(): Unit {
    // 注意：如果你要把一个函数赋值给一个变量，也想简写成lambda表达式，那就不能省略lambda参数类型，如

    // val du0 = ::test1
    // 常规写法
    val du1 = fun(a: Int): String {
        return (a * a).toString()
    }
    val du2 = { a: Int ->
        (a * a).toString()
        println("hello")
    }

    val du3 = { a: Int, b: String ->
        println(a)
        println(b)
        b.toUpperCase(Locale.ROOT)
    }

    // 确实需要省略掉方法参数
    // （只有一个参数）
    val du4: (a: Int) -> String = {
        (it * 1000).toString()
    }

    // （只有一个参数）
    val du5: (Int) -> String = {
        (it * it).toString()
    }
    // 有多个参数，有多个参数的时候，= 右边需要指明参数个数异议对应，如不需要使用，可以使用 _ 代替
    val du6: (Int, Int, String) -> String = { x, _, z ->
        println("x = $x z = $z")
        z.toUpperCase(Locale.ROOT)
    }

//    println("函数赋值给一个变量之后的lambda写法1 ${du3(29, "hello")}")
//    println("函数赋值给一个变量之后的lambda写法2 ${du2(29)}")
    println("函数赋值给一个变量之后的lambda写法3 ${du3(29, "hi")}")
    println("函数赋值给一个变量之后的lambda写法4 ${du4(2)}")
    println("函数赋值给一个变量之后的lambda写法5 ${du5(2)}")
    println("函数赋值给一个变量之后的lambda写法6 ${du6(2, 3, "hi")}")
}

object listener {
    fun setOnAListener(f: (x: Int) -> Unit) {

    }

    fun set2ArgumentListener(f: (x: Int, y: String, z: Boolean) -> Unit): Unit {}
}


fun test1(a: Int): String {
    return (a * a).toString()
}

fun test2(a: Int, b: Int, c: Int): String {
    return (a + b + c).toString()
}

val ok: (Int) -> String = {
    (it * 2).toString() // it 可以被推断出是 Int 类型
}


fun alpha(inFun: (x: Int) -> Int, inArgument: Int): String {
    return inFun(inArgument).toString()
    // 这样调用实际是调用invoke()方法
    // return inFun.invoke(inArgument).toString()
}


fun a(x: Int): Int {
    return x * x
}

fun b(x: Int): Int {
    return x + x
}

fun c(x: Int): Int {
    return x * 10000
}

