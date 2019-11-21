package com.lin.aopdemotest

import android.content.Intent
import android.os.Bundle
import com.lin.apiLog.MyTest2
import com.lin.apiLog.MyTest3
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity(): BaseActivity() {
    constructor(name: String):this(){

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv1.text = getText1("Dike")+ "....."+MyTest2().getName()+":"+ MyTest3().getName()

        tv1.setOnClickListener {

        }

        tv2.setOnClickListener {
            jumpSecondActivity()
        }

        MyTest2().test()
    }

    fun getText1(name: String): String{
        return "Hello world " + name
    }


    fun jumpSecondActivity(){
        var intent = Intent(this,SecondActivity::class.java)
        startActivity(intent)
    }
}
