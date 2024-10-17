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
                .csrf().disable() // Disable CSRF protection for easier testing
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/api/auth/login").permitAll() // Allow all users to access the login endpoint
                        .requestMatchers("/api/gebruikers/**").hasAnyRole("FIETSTECHNICUS", "BALIEPERSOON", "VOORRAADBEHEERDER") // Allow access to user management for all roles
                        .requestMatchers("/api/fietsen/**").hasRole("BALIEPERSOON") // Allow Baliepersoneel to access bike registration
                        .requestMatchers("/api/reparaties/**").hasRole("FIETSTECHNICUS") // Allow Fietstechnicus to manage repairs
                        .requestMatchers("/api/onderdelen/**").hasRole("VOORRAADBEHEERDER") // Allow Voorraadbeheerder to manage parts
                        .anyRequest().authenticated() // Require authentication for any other request
                )
                .httpBasic(); // Enable basic HTTP authentication

        return http.build();
    }
}