/*
 * ActivityAspect      2016-03-04
 * Copyright (c) 2016 hujiang Co.Ltd. All right reserved(http://www.hujiang.com).
 * 
 */

package com.lin.apiLog

import android.util.Log
import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.*


@Aspect
class ActivityAspect {
    val TAG = this.javaClass.simpleName.toString()

    @After("execution(* android.support.v4.app.FragmentActivity.onResume(..))")
    @Throws(Throwable::class)
    fun onResumeMethod(joinPoint: JoinPoint) {
        Log.e("lin", "resume=" + joinPoint.getThis())

    }

    @After("execution(* android.support.v4.app.FragmentActivity.onPause(..))")
    @Throws(Throwable::class)
    fun onPauseMethod(joinPoint: JoinPoint) {
        Log.e("lin", "pause=" + joinPoint.getThis())
    }

    @Before("execution(* android.support.v4.app.FragmentActivity.onCreate(..))")
    @Throws(Throwable::class)
    fun beforeCreate(joinPoint: JoinPoint) {
        Log.e("lin", "onCreate=" + joinPoint.getThis())
    }

}