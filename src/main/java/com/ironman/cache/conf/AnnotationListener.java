package com.ironman.cache.conf;

import com.ironman.cache.annotation.IronmanCache;
import com.ironman.cache.annotation.IronmanCacheEntity;
import com.ironman.cache.service.CustomAccountService;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Ironman
 * @Description:
 * @Date: Created in 15:30 2017/12/22 0022
 **/
public class AnnotationListener implements ServletContextListener {

	public static Map<String, IronmanCacheEntity> cacheEntityMap = new HashMap<>();

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent){
		System.out.println("AnnotationListener initializing...");
		Class clazz = CustomAccountService.class;
		Method[] methods = clazz.getDeclaredMethods();
		if(methods != null && methods.length != 0){
			for (Method method : methods) {
				String name = clazz.getName() + "." + method.getName();
				if(method.isAnnotationPresent(IronmanCache.class)){
					System.out.println(name);
					IronmanCache ironmanCache = method.getAnnotation(IronmanCache.class);
					System.out.println(ironmanCache.key() + ":" + ironmanCache.value());
					IronmanCacheEntity cacheEntity = new IronmanCacheEntity();
					cacheEntity.setKey(ironmanCache.key());
					cacheEntity.setValue(ironmanCache.value());
					cacheEntityMap.put(method.getName(), cacheEntity);
				}
			}
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent){

	}
}
