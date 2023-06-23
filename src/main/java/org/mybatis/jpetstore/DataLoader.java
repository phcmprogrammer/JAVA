package org.mybatis.jpetstore;

import org.mybatis.jpetstore.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

	private AccountService accountservice;

	@Autowired
	public DataLoader(AccountService accountservice) {
		this.accountservice = accountservice;
	}

	public void run(ApplicationArguments args) {
		System.out.println(accountservice.getAccount("ACID"));
	}
}
