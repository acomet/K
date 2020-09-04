package com.cat.blue.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Switch
import com.cat.blue.R
import com.cat.blue.bean.User
import com.cat.blue.utils.DalasCalf
import com.cat.blue.utils.L
import com.cat.blue.utils.catIsEmpty
import com.cat.blue.utils.catIsPhone
import com.cat.blue.utils2.B
import com.cat.blue.utils2.mathFans
import com.cat.indigo.utils.getDeviceHeight
import kotlinx.coroutines.CoroutineScope
import java.util.*

class MainActivity : AppCompatActivity() {

    private var loginBT: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loginBT = findViewById(R.id.registerBT)
        loginBT?.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
            }
        })

        loginBT?.setOnClickListener() {
            when (it.id) {
                0 -> {

                }
                1 -> println("hello")
                2 -> println("hi")
            }
        }


        //loginBT?.setOnTouchListener { view, motionEvent -> false }

        // learnList()
        // learnObject()
        // learnVisibility()
        // learnCoroutine()

//        val ok: (Int) -> String = {
//            (it * 2).toString() // it 可以被推断出是 Int 类型
//        }
//
//        println(ok(100))


//        a(::b)
//        val fb = ::b
//        fb(10, 20)
//
//        // 可以直接为一个接收函数类型的函数传递一个函数
//        a(fun(x: Int, y: Int): Int {
//            return x + y
//        })
//
//        // 直接把一个函数复制给一个变量
//        val ffb = fun(name: String): String {
//            return name.toUpperCase(Locale.ROOT)
//        }
    }

    private fun learnCoroutine() {
        //val coroutineScope = CoroutineScope(this)
    }

    fun a(f: (x: Int, y: Int) -> Int): Int {
        return 8
    }

    fun b(x: Int, y: Int): Int {
        return x * y
    }

    fun setOnClickListener(onClick: (v: View) -> Unit) {
        //this.onClick = onClick
    }

    private fun learnVisibility() {
        // getDeviceHeight()
        val basketball = B()
        basketball.test()
        // 引用失败，因为mathColor是file（文件）级别的private，只能在mathUtils.kt可见
        // L.i(mathColor)

        L.i(mathFans)
    }

    private fun learnList() {

        var list0 = listOf("Android", "iOS")
        val list1 = mutableListOf<String>()

        // 增
        list1.add("one")
        list1.add("two")
        list1.add("three")
        list1.add("four")
        // 删
        list1.removeAt(3)
        // 改
        list1[1] = "2"
        // 查
        L.i("list查: ${list1[1]}")
        L.i("list: $list1")

        val set0 = setOf("1", "2", 3)
        val set1 = mutableSetOf<String>()

        set1.add("08")
        set1.add("24")

        val map0 = mapOf("one" to 1, "two" to 2, "three" to 3)
        val map1 = mutableMapOf<String, String>()
        map1["one"] = "ONE"
        map1["two"] = "TWO"
        map1["three"] = "THREE"

    }

    private fun learnObject() {
        val name = "Kelvin Durant"
        L.i(name)
        catIsEmpty(name)
        catIsPhone(name)

        var user = User(address = "ShenZhen", age = 24, name = "OK")
        L.i(user.toString())
        L.i(User.nickname)
        User.sayHello("Kobe Bryant")

        User.Hobby.playingBasketball()
        User.Hobby.play("EA SPORT")
        L.i(User.Hobby.hobbies)

        User.Computer.playingComputer()
        L.i(User.Computer.computer)

        L.i("获取顶层生命属性： $DalasCalf")

        User.eat()
        L.i(User.showName())
    }
}