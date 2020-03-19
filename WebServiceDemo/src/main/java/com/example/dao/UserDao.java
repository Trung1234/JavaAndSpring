/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.dao;

import com.example.models.User;
import com.example.repositories.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Admin
 */
@Component
public class UserDao {
    @Autowired
    private UserRepository userRepository;
    
    public List<User> findAllUsers(){
        List<User> users = userRepository.findAll();
        return  users;
    }
    
    public boolean saveUser(User user){
        userRepository.save(user);
        return true;
    }
    public void deleteUserById(int id) {
	User user = userRepository.findById(id).get();
	userRepository.delete(user);
    }
}
