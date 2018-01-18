package com.ironman.cache.controller;

import com.ironman.cache.domain.Account;
import com.ironman.cache.service.CustomAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: ZJW
 * @Description: https://www.ibm.com/developerworks/cn/opensource/os-cn-spring-cache/
 * @Date: Created in 15:53 2017/10/14 0014
 * @Modified by:
 **/
@Controller
public class TestController {
	@Autowired
	private CustomAccountService accountService;

	@RequestMapping("xxx")
	public String xxx(){
		System.out.println("a");
		return "index";
	}

	@RequestMapping("login")
	@ResponseBody
	public Account login(String username){
		System.out.println(username);
		Account account = accountService.getAccountByName(username);
		return account;
	}
}
