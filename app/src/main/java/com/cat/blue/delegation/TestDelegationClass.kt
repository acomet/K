package com.cat.blue.delegation

interface Hotboom {
    fun buy(machine: String)
}

class Agency(val name: String) : Hotboom {
    override fun buy(machine: String) {
        println("I'm $name, now someone let me buy a $machine")
    }
}

// by 后面的对象实际上会被存储在类的内部，编译器会把父接口中的方法全部实现出来，并且将实现全部移交给储存在类的内部的对象
class Kelvin(agency: Agency) : Hotboom by agency

fun main() {
    val agency = Agency("拉卡泽特")
    Kelvin(agency).buy("Computer")
}