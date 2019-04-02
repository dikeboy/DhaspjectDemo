package com.lin.aopdemotest

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

open class BaseActivity: AppCompatActivity(){
    init {

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}