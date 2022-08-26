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

import com.banking.model.User;
import com.banking.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService service;

	// ********************Working properly, dont change******************
	// 1 add user.......500 status code applied
	@PostMapping("/adduser") // tasted on postman...ok // response=ok,error=ok;
	public ResponseEntity<User> addUser(@Valid @RequestBody User user) {
		try {
			service.saveUser(user);
			return ResponseEntity.of(Optional.of(user));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	// ********************Working properly, dont change***************
	// 2 get one by one user......204 status code apply
	@GetMapping("/getuserbyid/{id}") // tested on postman..ok //response=ok,error=ok
	public ResponseEntity<User> getuserById(@Valid @PathVariable int id) {
		User user = null;
		try {
			user = service.getUserById(id);
			return ResponseEntity.of(Optional.of(user));

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
	}

	// ***********************Working properly,dont change************************
	// 3 get all users ...status code 204 applied
	@GetMapping("/getallusers") // tested but response=ok,error=not ok
	public ResponseEntity<List<User>> getAllUsers() {

		this.service.getAllUsers();
		List<User> list = service.getAllUsers();
		if (list.isEmpty() == false) {
			return ResponseEntity.of(Optional.of(list));
		} else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}

	}

	// *******************Working properly, dont change******************
	// 4 update user
	@PutMapping("/updateuser")
	public ResponseEntity<User> updateUser(@Valid @RequestBody User user) {
		try {
			service.updateUser(user);
			return ResponseEntity.of(Optional.of(user));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
	}

	// *****************Working properly, dont change***********************
	// 5 delete user by id
	@DeleteMapping("/deleteuserbyid/{id}") // tested on postman ok
	public ResponseEntity<User> deleteUser(@Valid @PathVariable int id) {
		try {
			service.deleteUserById(id);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
	}
}
