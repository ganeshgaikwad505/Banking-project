package com.banking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.model.User;
import com.banking.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	// 1 save user one by one
	public User saveUser(User user) {
		return repository.save(user);
	}

	// 2 update user
	public User updateUser(User user) {
		User existingUser = repository.findById(user.getUserId()).orElse(null);
		existingUser.setName(user.getName());
		existingUser.setEmail(user.getEmail());
		existingUser.setMobile(user.getMobile());
		existingUser.setSecondMobile(user.getSecondMobile());
		existingUser.setDob(user.getDob());
		existingUser.setGender(user.getGender());
		existingUser.setAccounts(user.getAccounts());
		return repository.save(existingUser);
	}

	// 3.get user by id
	public User getUserById(int id) {
		return repository.findById(id).orElse(null);
	}

	// 4 get all users
	public List<User> getAllUsers() {
		return repository.findAll();
	}

	// 5 delete user
	public String deleteUserById(int id) {
		repository.deleteById(id);
		return "User removed succssfully !!!" + id;
	}

}
