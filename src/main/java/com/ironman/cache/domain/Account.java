package com.ironman.cache.domain;

import java.io.Serializable;

/**
 * @Author: ZJW
 * @Description:
 * @Date: Created in 17:25 2017/12/17 0017
 **/
public class Account implements Serializable{


	private String username;
	private String psw;

	public Account(String username){
		this.username = username;
	}

	public Account(){
	}

	public Account(String username, String psw){
		this.username = username;
		this.psw = psw;
	}

	public String getUsername(){
		return username;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getPsw(){
		return psw;
	}

	public void setPsw(String psw){
		this.psw = psw;
	}
}
