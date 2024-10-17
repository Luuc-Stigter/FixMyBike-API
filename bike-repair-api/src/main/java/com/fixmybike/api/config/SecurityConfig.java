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
                .csrf().disable()
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/api/auth/login").permitAll()
                        .requestMatchers("/api/gebruikers/**").hasAnyRole("FIETSTECHNICUS", "BALIEPERSOON", "VOORRAADBEHEERDER")
                        .requestMatchers("/api/fietsen/**").hasRole("BALIEPERSOON")
                        .requestMatchers("/api/reparaties/**").hasRole("FIETSTECHNICUS")
                        .requestMatchers("/api/onderdelen/**").hasRole("VOORRAADBEHEERDER")
                        .anyRequest().authenticated()
                )
                .httpBasic();

        return http.build();
    }
}