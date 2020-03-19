/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.controllers;

import com.example.dao.UserDao;
import com.example.models.User;

import java.lang.reflect.Method;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Admin
 */
@RestController
public class MainController {
    @Autowired
    public UserDao userDao;
    
    @RequestMapping(value="/users",method = RequestMethod.GET,produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<User> getUsers(){
        List<User> users = userDao.findAllUsers();
        return users;
    }
    
    
    @RequestMapping(value="/deleteUser/{id}",method = RequestMethod.GET,produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public void deleteUser(@PathVariable("id") int id){
        userDao.deleteUserById(id);
    } 
    
    @RequestMapping(value="/createUser",method = RequestMethod.POST ,produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public void createUser(@RequestBody User user){
        userDao.saveUser(user);
    } 
    
    @RequestMapping(value="/updateUser",method = RequestMethod.PUT ,produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public void updateUser(@RequestBody User user){
        userDao.saveUser(user);
    } 
}
