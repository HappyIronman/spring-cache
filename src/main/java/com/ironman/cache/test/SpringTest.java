package com.ironman.cache.test;

import com.ironman.cache.service.CustomAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author: ZJW
 * @Description: https://www.ibm.com/developerworks/cn/opensource/os-cn-spring-cache/
 * @Date: Created in 17:29 2017/12/17 0017
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class SpringTest {
	@Autowired
	private CustomAccountService accountService;

	@Test
	public void test1(){
		System.out.println("query1:");
		String username = "ironman2";
		accountService.getAccountByName(username);
		System.out.println("query2:");
		accountService.getAccountByName(username);
		System.out.println("update without cache:");
	}

	@Test
	public void test2() throws ParseException{
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		System.out.println(year);
		System.out.println(month);


		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMM");
		System.out.println(formatter.format(new Date()));
	}
}
