package com.howtodoinjava.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.howtodoinjava.demo.model.User;


@Repository
public interface UserRepository
        extends JpaRepository<User, Long> {
 
}
