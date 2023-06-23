package org.mybatis.jpetstore.mapper;

import org.apache.ibatis.annotations.*;
import org.mybatis.jpetstore.domain.Account;

@Mapper
public interface AccountMapper {

	Account getAccountByUsername(String username);

	Account getAccountByUsernameAndPassword(String username, String password);

	void insertAccount(Account account);

	void insertProfile(Account account);

	void insertSignon(Account account);

	void updateAccount(Account account);

	void updateProfile(Account account);

	void updateSignon(Account account);

}
