/*
 * ActivityAspect      2016-03-04
 * Copyright (c) 2016 hujiang Co.Ltd. All right reserved(http://www.hujiang.com).
 * 
 */

package com.lin.api_log;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;


@Aspect
public class ContentAspect {
    public  final String TAG = this.getClass().getSimpleName().toString();

    @Around("execution(* com.lin.aopdemotest.MainActivity.getText1(..))")
    public Object onTestMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        Log.e(TAG, "source result is :::" +joinPoint.proceed());
        Object obj = joinPoint.getArgs()[0];
        return "Hello baby "+ obj;
    }

    @Around("execution(* com.lin.aopdemotest.MainActivity.jumpSecondActivity(..))")
    public void  onJumpMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        Log.e(TAG, "source this is :::" +joinPoint.getThis());
       Class mClass =   Class.forName("com.lin.aopdemotest.ThirdActivity");
        Intent intent =new Intent((Context) joinPoint.getThis(),mClass);
        ((Context) joinPoint.getThis()).startActivity(intent);
    }
}