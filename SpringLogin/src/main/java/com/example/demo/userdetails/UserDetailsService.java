package com.example.demo.userdetails;

import org.springframework.security.core.userdetails.UserDetails;

public interface UserDetailsService {
	public UserDetails loadUserByUsername(String userName);
}
