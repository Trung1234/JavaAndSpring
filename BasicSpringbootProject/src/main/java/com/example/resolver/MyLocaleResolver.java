/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.resolver;

import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.LocaleResolver;

/**
 *
 * @author Admin
 */
public class MyLocaleResolver implements LocaleResolver{

    @Override
    public Locale resolveLocale(HttpServletRequest hsr) {
        Locale locale = null;
        String language = "";
        HttpSession session = hsr.getSession();
        if(session.getAttribute("lang")==null){
            language = "en";
            locale = Locale.ENGLISH;
        }else{
            language = session.getAttribute("lang").toString();
        if(language.equals("en")){
            locale = Locale.ENGLISH;
        } else if(language.equals("fr")) {
            locale = Locale.FRANCE;
        } else {
            locale = new Locale("vi", "VN");
        }
        }
        return locale;
        
    }

    @Override
    public void setLocale(HttpServletRequest hsr, HttpServletResponse hsr1, Locale locale) {
        
    }
    
}
