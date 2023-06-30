package org.mybatis.jpetstore.service;

import org.mybatis.jpetstore.DTO.AccountDTO;
import org.mybatis.jpetstore.domain.Account;

public interface AccountService {
	
	Account getAccount(String username);
	
	Account getAccount(String username, String password);
	
	Account insertAccount(Account account);
	
	Account updateAccount(Account account);

}
