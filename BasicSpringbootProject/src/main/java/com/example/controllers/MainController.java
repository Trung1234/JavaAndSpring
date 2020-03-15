/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Admin
 */
@Controller
public class MainController {
    
    
    
    @GetMapping("/")
    public String index() {
        return "index";
    }
    
    @GetMapping("/language")
    public String getLanguage(HttpServletRequest request, @RequestParam("lang") String language) {
        request.getSession().setAttribute("lang",language);
        return "redirect:/";
    }
    
    @GetMapping("/admin") 
    public String admin() {
        return "admin";
    }
    
    @GetMapping("/login") 
    public String login() {
        return "login";
    }
    
    @GetMapping("/403") 
    public String error() {
        return "403";
    }
    
    @GetMapping("/logout") 
    public String logout(HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth != null) {
            new SecurityContextLogoutHandler().logout(httpRequest, httpResponse, auth);
        }
        return "redirect:/";
    }

}
