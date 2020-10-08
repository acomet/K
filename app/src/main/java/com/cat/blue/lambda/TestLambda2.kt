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
//    alpha1(100, { a -> "hello world" })
//    alpha1(100) { a -> "hello world" }
//    alpha1(100) {
//        println(it)
//        println(it)
//        "Hello cat"
//    }
//
//    alpha1(100) {
//        println(it)
//        return@alpha1 "origin = $it , and result is 'HELLO WORLD'"
//    }

    // 4
//    alpha2(100, 800) { a, b ->
//        a * b
//    }

    // 5
//    alpha3(5, 6) { a, b ->
//        println("返回多个结果的另类操作，神奇吧 a=$a, b=$b")
//    }

    // 6
//    alpha4(8, 10) { a, b ->
//        a * b
//    }.apply {
//        println("--001--$this")
//    }.apply {
//        println("--002--$this")
//    }.also {
//        println("--003--$it")
//    }.also {
//        println("--004--$it")
//    }

//    nothing(6){
//        println("hello world")
//    }

//    alpha0(6){
//        println(it)
//    }

    alpha1(6) {
        println(it)
        "HELLO REL"
    }

//    alpha11(3000) {
//        "结果是${(it + it)}"
//    }

//    alpha2(6, 5) { a, b ->
//        (a - b) * 100000
//    }
//
//    alpha2(6, 5) { a, _ ->
//        a * 100000
//    }

//    alpha3(9, 10) { alpha, beta ->
//        println("alpha=$alpha, beta=$beta")
//    }
//    alpha4(10, 20) { arg0, arg1 ->
//        println("arg0=$arg0, arg1=$arg1")
//        1000
//    }.apply {
//        println(this)
//    }

//    alpha4(100, 20) { a, b ->
//        a - b
//    }.let {
//        println(it)
//    }
}

// 方法有lambda，lambda有两个参数，有返回值， 方法整体有放回值
fun alpha4(x: Int, y: Int, predicate: (Int, Int) -> Int): Int {
    println("alpha4 原始x=$x, y=$y")
    return predicate(x, y)
}

// 方法有lambda，lambda有两个参数，无返回值， 方法整体无返回值【一般用于返回多个参数，这个就是kotlin牛逼的地方，可以返回多个参数】
fun alpha3(x: Int, y: Int, predicate: (Int, Int) -> Unit) {
    println("alpha3 原始x=$x, y=$y")
    predicate(x * x, y * y)
}

// 方法有lambda，lambda有两个参数，有返回值，方法整体没有返回值（其实就是同下）
fun alpha2(x: Int, y: Int, predicate: (Int, Int) -> Int) {
    println("alpha2 原始x=$x，y=$y")
    val result = predicate(x, y)
    println(result)
}

fun alpha11(x: Int, predicate: (Int) -> String) {
    println("alpha11 原始x=$x, res=${predicate(x)}")
}

// 方法参数有lambda，lambda有参数，有返回值， 方法整体没有返回值
fun alpha1(x: Int, predicate: (Int) -> String) {
    println("alpha1原始x=$x")
    val result = predicate(x + 100 + 200 + 300) // 在这里能拿到lambda的返回值
    println("result = $result")
    // predicate.invoke(x + 100 + 200 + 300)
}

// 方法参数有lambda，lambda有参数，无返回值， 方法整体没有返回值【一般用于处理回调】
fun alpha0(x: Int, callback: (Int) -> Unit) {
    println("alpha0原始x=$x")
    val result = x + 100 * 200 / 3 - 100
    // 回调经过各种风骚操作之后得到的结果
    callback(result)
}


// 方法参数有lambda，lambda无参数，无返回值， 方法整体没有返回值【很少用】
fun nothing(x: Int, predicate: () -> Unit) {
    println("nothing原始x=$x")
    predicate.invoke()
}