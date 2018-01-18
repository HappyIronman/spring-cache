package com.ironman.cache.annotation;

import java.lang.annotation.*;

/**
 * @Author: Ironman
 * @Description:
 * @Date: Created in 14:55 2017/12/22 0022
 **/
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitName {
	String value() default "";
}
