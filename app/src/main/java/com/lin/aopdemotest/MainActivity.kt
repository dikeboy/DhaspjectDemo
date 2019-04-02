package com.lin.aopdemotest

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv1.text = getText1("Dike")

        tv1.setOnClickListener {

        }

        tv2.setOnClickListener {
            jumpSecondActivity()
        }
    }

    fun getText1(name: String): String{
        return "Hello world " + name
    }


    fun jumpSecondActivity(){
        var intent = Intent(this,SecondActivity::class.java)
        startActivity(intent)
    }
}
