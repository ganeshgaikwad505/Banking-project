package com.banking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.model.Account;
import com.banking.repository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	private AccountRepository repository;

	// 1 save Account one by one
	public Account saveAccount(Account account) {
		return repository.save(account);
	}
	

	// 2 update Account by id
	public Account updateAccount(Account account) {
		Account existingAccount = repository.findById(account.getAccountId()).orElse(null);
		existingAccount.setBranchName(account.getBranchName());
		existingAccount.setAccountType(account.getAccountType());
		existingAccount.setBalance(account.getBalance());
		return repository.save(existingAccount);
	}

	// 3.get Account by id
	public Account getAccountById(long id) {
		return repository.findById(id).orElse(null);
		
	}

	// 4 get all accounts
	public List<Account> getAllAccount() {
		return repository.findAll();
	}

	// 5 delete Account
	public String deleteAccountById(long id) {
		repository.deleteById(id);
		return "Account removed succssfully !!!" + id;
	}

	
}
