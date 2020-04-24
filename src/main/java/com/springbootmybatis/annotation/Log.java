package com.springbootmybatis.annotation;

import java.lang.annotation.*;

/**
 * Created by xkx on 2020/4/24.
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
    String value() default "";
}
