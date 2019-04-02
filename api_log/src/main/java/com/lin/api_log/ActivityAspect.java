/*
 * ActivityAspect      2016-03-04
 * Copyright (c) 2016 hujiang Co.Ltd. All right reserved(http://www.hujiang.com).
 * 
 */

package com.lin.api_log;

import android.util.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;



@Aspect
public class ActivityAspect {
    public  final String TAG = this.getClass().getSimpleName().toString();

    @After("execution(* android.support.v4.app.FragmentActivity.onResume(..))")
    public void onResumeMethod(JoinPoint joinPoint) throws Throwable {
        Log.e("lin","resume="+joinPoint.getThis());

    }

    @After("execution(* android.support.v4.app.FragmentActivity.onPause(..))")
    public void onPauseMethod(JoinPoint joinPoint) throws Throwable {
        Log.e("lin","pause="+joinPoint.getThis());
    }
    @Before("execution(* android.support.v4.app.FragmentActivity.onCreate(..))")
    public void beforeCreate(JoinPoint joinPoint) throws Throwable {
        Log.e("lin","onCreate="+joinPoint.getThis());
    }

}