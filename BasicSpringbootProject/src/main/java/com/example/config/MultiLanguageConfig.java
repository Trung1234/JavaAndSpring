/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.config;

import com.example.resolver.MyLocaleIntersecter;
import com.example.resolver.MyLocaleResolver;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

/**
 *
 * @author Admin
 */
@Configuration
public class MultiLanguageConfig implements WebMvcConfigurer{
    @Bean(name = "localeResolver")
    public LocaleResolver getLocaleResolver() {
//         CookieLocaleResolver cookie = new CookieLocaleResolver();
//         cookie.setCookieDomain("myAppLocaleCookie");
//         cookie.setCookieMaxAge(1200);
//         return cookie;
        // tự động gọi đến MyLocaleResolver
        return new MyLocaleResolver();
    }
    @Bean(name = "messageSource")
    public MessageSource getMessageReSource(){
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:languages/message");
        messageSource.setDefaultEncoding("UTF8");
        return messageSource;
    }
    @Override
    public void addInterceptors(InterceptorRegistry ir) {
//        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
//        lci.setParamName("lang");
//        ir.addInterceptor(lci);
        MyLocaleIntersecter localeInte = new MyLocaleIntersecter();
        ir.addInterceptor(localeInte).addPathPatterns("/*");
    }
}
