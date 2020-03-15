/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.repositories;

import com.example.models.Role;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Admin
 */
public interface RoleRepository extends CrudRepository<Role, Integer>{
    
    Role findRoleByName(String name);
}
