package com.example.demo.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.AppUser;



@Repository
public interface AppUserRepository
        extends PagingAndSortingRepository<AppUser, Long> {

	AppUser findByUserName(String name);
}