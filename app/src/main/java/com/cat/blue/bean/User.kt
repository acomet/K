package com.cat.blue.bean

import com.cat.blue.interfaze.Human
import com.cat.blue.utils.L

class User {
    var name: String?
    var age: Int?
    var address: String?
//    get() = address + "BR"

    init {
        L.i("NOW INIT THE USER")
    }

    constructor(name: String, age: Int, address: String) {
        this.address = address
        this.age = age
        this.name = name
    }

    object Hobby {
        val hobbies = "Swimming, Basketball, Football"
        fun playingBasketball() {
            L.i("playingBasketball...")
        }

        fun play(hobby: String) {
            L.i("playing $hobby")
        }
    }

    object Computer {
        val computer = "Google computer"
        fun playingComputer() {
            L.i("playingComputer...")
        }
        fun getUserAvatar() {

        }
    }

    companion object : Human{
        val nickname = "calf"
        fun sayHello(msg: String) {
            L.i("Hello $msg")
        }

        override fun eat() {
            L.i("NOW EAT IMPLEMENT FROM HUMAN")
        }

        override fun showName(): String {
            return nickname
        }
    }

    override fun toString(): String {
        return "User(name=$name, age=$age, address=$address)"
    }
}