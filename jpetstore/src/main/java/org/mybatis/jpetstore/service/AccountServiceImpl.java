package org.mybatis.jpetstore.service;

import java.util.Optional;

import org.mybatis.jpetstore.domain.Account;
import org.mybatis.jpetstore.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountMapper accountMapper;

	public AccountServiceImpl(AccountMapper accountMapper) {
		this.accountMapper = accountMapper;
	}

	public Account getAccount(String username) {
		return accountMapper.getAccountByUsername(username);
	}

	public Account getAccount(String username, String password) {
		return accountMapper.getAccountByUsernameAndPassword(username, password);
	}

	@Transactional
	public Account insertAccount(Account account) {
		accountMapper.insertAccount(account);
		accountMapper.insertProfile(account);
		accountMapper.insertSignon(account);
		return account;
	}

	/**
	 * Update account.
	 *
	 * @param account the account
	 */
	@Transactional
	public Account updateAccount(Account account) {

		accountMapper.updateAccount(account);
		accountMapper.updateProfile(account);

		Optional.ofNullable(account.getPassword()).filter(password -> password.length() > 0)
				.ifPresent(password -> accountMapper.updateSignon(account));
		return account;
	}

}
