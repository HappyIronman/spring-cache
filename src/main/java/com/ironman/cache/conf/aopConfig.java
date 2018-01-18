package com.ironman.cache.conf;

import com.ironman.cache.annotation.IronmanCache;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

/**
 * @Author: Ironman
 * @Description:
 * @Date: Created in 15:26 2017/12/22 0022
 **/
public class aopConfig {
	public Object annotationConfig(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("拦截到了" + pjp.getSignature().getName() + "方法...");
		Signature signature = pjp.getSignature();
		MethodSignature methodSignature = (MethodSignature) signature;
		Method targetMethod = methodSignature.getMethod();
		if(targetMethod.isAnnotationPresent(IronmanCache.class)){
			System.out.println(targetMethod.getName());
			IronmanCache ironmanCache = targetMethod.getAnnotation(IronmanCache.class);
			System.out.println(ironmanCache.key() + ":" + ironmanCache.value());
		}
		Object object = pjp.proceed();
		return object;
	}
}
