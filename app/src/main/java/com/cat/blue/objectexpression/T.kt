package com.cat.blue.objectexpression


fun main() {
    val mouse = Mouse()
    // 如果你的接口是java语言的interface，那么这里你可以使用lambda表达式
    // 古老写法1
//    mouse.setOnDoubleClickListener(object : OnDoubleClickListener {
//        override fun onFastClick(x: Int, y: Int) {
//
//        }
//
//    })

    // kotlin 推荐写法2
//    mouse.setOnDoubleClickListener { x, y ->
//
//    }

    // 如果参数都没有使用，可以使用下划线替代
//    mouse.setOnDoubleClickListener { _, _ ->
//
//    }

    // 但是如果的接口本身就是kotlin语言写的，那么这里就不能再用lambda了，lambda不允许使用以下这种的方案
//    mouse.setOnJumpListener{x,y->
//
//    }

    // 如果只想做回调操作，可以使用object，但是kotlin更推荐使用lambda
//    mouse.setOnJumpListener(object : OnJumpListener {
//        override fun jump(x: String, y: String) {
//
//        }
//    })

    // 也可以直接使用匿名函数，如下
    mouse.setOnShowListener { x, y ->
        println("x=$x, y=$y")
    }

    mouse.setOnDrinkListener("Coca Cola") { x, y ->
        println("x=$x, y=$y")
    }

    mouse.setOnEatListener({ arg ->
        Unit
        println("arg=$arg")
    }, { x, y ->
        String
        println("x=$x, y=$y")
        x + " " + y
    })

//    mouse.setOnDanceListener(object : Dance() {
//
//        override fun dance0() {
//            super.dance0()
//            println("hello world")
//        }
//
//        override fun dance(x: String) {
//            dance0()
//        }
//    })
}

interface OnJumpListener {
    fun jump(x: String, y: String)
}


abstract class Dance {

    open fun dance0() {

    }

    abstract fun dance(x: String)
}

class Mouse {
    lateinit var doubleClickListener: OnDoubleClickListener
    lateinit var jumpListener: OnJumpListener
    lateinit var dance: Dance

    fun setOnDoubleClickListener(listener: OnDoubleClickListener) {
        this.doubleClickListener = listener
    }

    fun show() {
        this.doubleClickListener.onFastClick(1000, 2000)
    }

    fun setOnDanceListener(dance: Dance) {
        this.dance = dance
    }

    fun dance() {
        this.jumpListener.jump("1000", "2000")
    }

    fun setOnJumpListener(jumpListener: OnJumpListener) {
        this.jumpListener = jumpListener
    }

    fun setOnShowListener(callback: (String, String) -> Unit) {
        callback("{'code':200, 'data':'hello world'}", "HELLO WORLD")
    }
    
    fun setOnDrinkListener(drink: String, callback: (String, String) -> Unit) {
        println("drink=$drink")
        callback("HELLO", "CAT")
    }

    fun setOnEatListener(c0: (String) -> Unit, c1: (String, String) -> String) {
        c0("hello")
        val result = c1.invoke("C1 IS C1", "C2 IS C2")
        println("result = $result")
    }
}