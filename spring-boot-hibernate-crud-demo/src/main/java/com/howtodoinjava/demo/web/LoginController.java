package com.howtodoinjava.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.howtodoinjava.demo.model.User;
import com.howtodoinjava.demo.service.UserService;

@Controller
@RequestMapping("/auth")
public class LoginController {

	@Autowired
	UserService service;
	
	@GetMapping("/login")
	public String showLogin() {
		return "login";
	}

	// Check for Credentials
	@PostMapping("/login")
	public String login(@ModelAttribute(name = "loginForm") User login, Model m) {
		String uname = login.getName();
		String pass = login.getPassword();
		if (service.checkLogin(uname, pass)) {
			m.addAttribute("uname", uname);
			m.addAttribute("pass", pass);
			return "welcome";
		}
		m.addAttribute("error", "Incorrect Username & Password");
		return "redirect:/auth/login";
	}
}