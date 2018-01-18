package com.ironman.cache.service;

import com.ironman.cache.annotation.IronmanCache;
import com.ironman.cache.domain.Account;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @Author: Ironman
 * @Description:
 * @Date: Created in 15:18 2017/12/22 0022
 **/
@Service
public class CustomAccountService {


	@IronmanCache(value = "accountCache",key="aaa")// 使用了一个缓存名叫 accountCache (如果运用redis,需要设置此值,但是没什么实际用处)
	public Account getAccountByName(String userName){
		// 方法内部实现不考虑缓存逻辑，直接实现业务
		System.out.println("real query account." + userName);
		return getFromDB(userName);
	}



	private Account updateAccountDB(Account account){
		System.out.println("accountDB updated");
		return account;
	}

	private Account getFromDB(String acctName){
		System.out.println("real querying db..." + acctName);
		return new Account(acctName);
	}
}
