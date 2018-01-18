package com.ironman.cache.annotation;

import java.lang.annotation.*;

/**
 * @Author: Ironman
 * @Description:
 * @Date: Created in 15:20 2017/12/22 0022
 **/
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface IronmanCache {
	String value() default "";

	String key() default "";
}

