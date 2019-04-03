package com.lin.aopdemotest.anno;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface WithInMark {

    public String value() default "";

}
