package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.*;



public interface UserService {
	
	User saveUser(User user);
	User getUser(Long id);
	public Long findMaxID();
	List<User> getAllUsers();
	boolean existsUser(Long id);
}
