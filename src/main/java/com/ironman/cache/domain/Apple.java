package com.ironman.cache.domain;

import com.ironman.cache.annotation.FruitName;

/**
 * @Author: Ironman
 * @Description:
 * @Date: Created in 14:56 2017/12/22 0022
 **/
public class Apple {

	@FruitName(value = "apple")
	private String appleName;


	public void setAppleName(String appleName){
		this.appleName = appleName;
	}

	public String getAppleName(){
		return appleName;
	}

	public void displayName(){
		System.out.println("水果的名字是：苹果");
	}

}
