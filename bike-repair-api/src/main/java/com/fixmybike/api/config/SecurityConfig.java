package com.fixmybike.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable() // Zet CSRF-beveiliging uit voor eenvoudiger testen
                .authorizeRequests()
                .anyRequest().permitAll() // Sta alle verzoeken toe
                .and()
                .httpBasic(); // Activeer basis HTTP-authenticatie (optioneel)

        return http.build();
    }
}