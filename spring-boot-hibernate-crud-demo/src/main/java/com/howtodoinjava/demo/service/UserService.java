package com.howtodoinjava.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.howtodoinjava.demo.model.User;
import com.howtodoinjava.demo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository repository;

	public boolean checkLogin(String name, String password) {
		List<User> users = repository.findAll();
		for (User user : users) {
			if(user.getName().equals(name) && user.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}
}
