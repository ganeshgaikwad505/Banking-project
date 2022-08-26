package com.banking.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.banking.model.Account;
import com.banking.service.AccountService;

@RestController
public class AccountController {

	@Autowired
	private AccountService service;

	// *************Working properly**************************
	// 1 add account............500 status code applied
	@PostMapping("/addaccount") // tasted on postman
	public ResponseEntity<Account> addAccount(@Valid @RequestBody Account account) {
		try {
		service.saveAccount(account);
		return ResponseEntity.of(Optional.of(account));
		}catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	// *************Working properly, dont change**************************
	// 2 get one by one account.....204 status code applied
	@GetMapping("/getaccountbyid/{id}") // tested on postman ...ok
	public ResponseEntity<Account> getaccountById(@Valid @PathVariable long id) {
		Account account = null;
		try {
			account = service.getAccountById(id);
			return ResponseEntity.of(Optional.of(account));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
	}
	
//============working dont change======================
	@PutMapping("/updateaccount")// 204 status code applied....tested ok
	public ResponseEntity<Account> updateAccount(@Valid @RequestBody Account account){
		try {
		service.updateAccount(account);
		return ResponseEntity.of(Optional.of(account));
		}catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
	}

	// ****************Working properly,dont change************************
	// 4 get all accounts.....204 status code applied
	@GetMapping("/getallaccounts") // tested on postman okk
	public ResponseEntity<List<Account>> getAllaccount() {
		this.service.getAllAccount();
		List<Account> list = service.getAllAccount();
		if (list.isEmpty() == false) {
			return ResponseEntity.of(Optional.of(list));
		} else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}

	}

	// ************Working properly, dont change**********************
	// 5 delete account by id.....204 status code applied
	@DeleteMapping("/deleteaccountbyid/{id}") // tested on postman...ok but not show status code
	public ResponseEntity<Account> deleteAccount(@Valid @PathVariable long id) {
		try {
			service.deleteAccountById(id);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}

	}
}
