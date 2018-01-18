package com.ironman.cache.service;

import com.ironman.cache.domain.Account;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @Author: ZJW
 * @Description:
 * @Date: Created in 17:24 2017/12/17 0017
 **/
@Service
public class AccountService {

	@Cacheable(value = "accountCache")// 使用了一个缓存名叫 accountCache (如果运用redis,需要设置此值,但是没什么实际用处)
	public Account getAccountByName(String userName){
		// 方法内部实现不考虑缓存逻辑，直接实现业务
		System.out.println("real query account." + userName);
		return getFromDB(userName);
	}

	@CacheEvict(value = "accountCache", key = "#account.getUsername()", beforeInvocation = false)// 缓存名叫 accountCache
	// beforeInvocation	是否在方法执行前就清空，缺省为 false，如果指定为 true，则在方法还没有执行的时候就清空缓存，缺省情况下，如果方法执行抛出异常，则不会清空缓存
	// 按照条件操作缓存	@Cacheable(value="accountCache",condition="#userName.length() <= 4")
	// 多参数key组合    @Cacheable(value="accountCache",key="#userName.concat(#password)")
	public void updateAccount(Account account){
		this.updateAccountDB(account);
	}

	@CachePut(value = "accountCache", key = "#account.getUsername()")// 更新 accountCache 缓存,返回值存入cache
	public Account updateAccountWithCache(Account account){
		return updateAccountDB(account);
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
