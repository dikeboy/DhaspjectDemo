/*
 * ActivityAspect      2016-03-04
 * Copyright (c) 2016 hujiang Co.Ltd. All right reserved(http://www.hujiang.com).
 * 
 */

package com.lin.apiLog

import android.content.Context
import android.content.Intent
import android.util.Log
import org.aspectj.lang.JoinPoint
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.*


@Aspect
class ContentAspect {
    val TAG = this.javaClass.simpleName.toString()

    @Around("execution(* com.lin.aopdemotest.MainActivity.getText1(..))")
    @Throws(Throwable::class)
    fun onTestMethod(joinPoint: ProceedingJoinPoint): Any {
        Log.e(TAG, "source result is :::" + joinPoint.proceed())
        val obj = joinPoint.args[0]
        return "Hello baby $obj"
    }

    @Around("execution(* com.lin.aopdemotest.MainActivity.jumpSecondActivity(..))")
    @Throws(Throwable::class)
    fun onJumpMethod(joinPoint: ProceedingJoinPoint) {
        Log.e(TAG, "source this is :::" + joinPoint.getThis())
        val mClass = Class.forName("com.lin.aopdemotest.ThirdActivity")
        val intent = Intent(joinPoint.getThis() as Context, mClass)
        (joinPoint.getThis() as Context).startActivity(intent)
    }

    @After("execution(* com.lin.aopdemotest.MyTest.test(..))")
    @Throws(Throwable::class)
    fun onmyTest(joinPoint: JoinPoint) {
        Log.e(TAG, "::::::com.lin........................:::")
    }

    @After("execution(* com.lin.apiLog.MyTest2.test(..))")
    @Throws(Throwable::class)
    fun mytest(joinPoint: JoinPoint) {
        Log.e(TAG, "  ........................:::")
    }

    @Around("execution(* com.lin.apiLog.MyTest2.getName(..))")
    @Throws(Throwable::class)
    fun mytestName(joinPoint: ProceedingJoinPoint): Any {
        return joinPoint.proceed().toString() + "赵四"
    }

    @Around("execution(* com.lin.apiLog.MyTest3.getName(..))")
    @Throws(Throwable::class)
    fun mytestName3(joinPoint: ProceedingJoinPoint): Any {
        Log.e(TAG, "source result is :::" + joinPoint.proceed())
        return "王五"
    }
}