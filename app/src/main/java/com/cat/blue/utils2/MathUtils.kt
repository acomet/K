package com.cat.blue.utils2

import com.cat.blue.utils.L

var DalasCalf = "达拉斯小牛"

class A {
    private var name = "Alpha"
    var age = 10

    fun showInfor() {
        L.i(mathColor)
    }
}

private var mathColor = "Orange"
var mathFans = "小风扇"

class B {
    var name = "Basketball"
    fun test(){
        val alpha = A()
        L.i(alpha.age.toString())

        // 引用失败，因为A中的name是class级别的private
        // L.i(alpha.name)

        L.i(mathColor)
    }
}