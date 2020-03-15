/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.config;

import com.example.models.Role;
import com.example.models.User;
import com.example.repositories.RoleRepository;
import com.example.repositories.UserRepository;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 *
 * @author Admin
 */
@Component
public class DataGenerate implements ApplicationListener<ContextRefreshedEvent>{

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private RoleRepository roleRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Override
    public void onApplicationEvent(ContextRefreshedEvent e) {
        if(userRepository.findByEmail("admin@gmail.com") == null) {
            User admin = new User();
            admin.setEmail("admin@gmail.com");
            admin.setPassword(passwordEncoder.encode("123456"));
            Set<Role> roles = new HashSet<Role>();
            roles.add(roleRepository.findRoleByName("ROLE_ADMIN"));
            roles.add(roleRepository.findRoleByName("ROLE_MEMBER"));
            admin.setRoles(roles);
            userRepository.save(admin);
        }
        if(userRepository.findByEmail("trung@gmail.com") == null) {
            User user = new User();
            user.setEmail("trung@gmail.com");
            user.setPassword(passwordEncoder.encode("abcxyz"));
            Set<Role> roles = new HashSet<Role>();
            roles.add(roleRepository.findRoleByName("ROLE_MEMBER"));
            user.setRoles(roles);
            userRepository.save(user);
        }
    }
    
}
