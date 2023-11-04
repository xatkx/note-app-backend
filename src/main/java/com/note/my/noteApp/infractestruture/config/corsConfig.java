/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.note.my.noteApp.infractestruture.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * @author kedwin
 */
@Configuration
@EnableWebMvc
public class corsConfig implements WebMvcConfigurer {
    
    @Override
     public void addCorsMappings(CorsRegistry registry) {
      registry
                .addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("*");
    }
}
