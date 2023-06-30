package org.mybatis.jpetstore.controller;

import org.mybatis.jpetstore.domain.Account;
import org.mybatis.jpetstore.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "API REST JpetStore")
@RestController
@RequestMapping(value = "account/")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@ApiOperation(value = "Seleciona Account pelo username")
	@GetMapping(value = "/{username}")
	public ResponseEntity<Account> getAccountByUsername(@PathVariable String username){
		Account account = accountService.getAccount(username);
		return ResponseEntity.ok(account);
	}

	@ApiOperation(value = "Seleciona Account pelo username e password")
	@GetMapping(value = "/{username}/{login}")
	public ResponseEntity<Account> getAccountByYsernameAndPassword(@PathVariable String username, String password) {
		Account account = accountService.getAccount(username);
		return ResponseEntity.ok(account);
	}

	@ApiOperation(value = "Cria uma Account")
	@PostMapping
	public ResponseEntity<Account> insertAccount(@RequestBody Account account) {
		Account obj = accountService.insertAccount(account);
		return ResponseEntity.ok().body(obj);
	}

	@ApiOperation(value = "Update de dados de uma Account")
	@PutMapping
	public ResponseEntity<Account> update(@RequestBody Account account) {
		Account obj = accountService.updateAccount(account);
		return ResponseEntity.ok().body(obj);
	}

}
