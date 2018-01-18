package com.ironman.cache.annotation;

/**
 * @Author: Ironman
 * @Description:
 * @Date: Created in 15:45 2017/12/22 0022
 **/
public class IronmanCacheEntity {
	private String key;
	private String value;

	public String getKey(){
		return key;
	}

	public void setKey(String key){
		this.key = key;
	}

	public String getValue(){
		return value;
	}

	public void setValue(String value){
		this.value = value;
	}
}
