package com.fixmybike.api.controller;

import com.fixmybike.api.model.Gebruiker;
import com.fixmybike.api.service.GebruikerService;
import com.fixmybike.api.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private GebruikerService gebruikerService;

    @Autowired
    private JwtUtil jwtUtil;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // Endpoint voor inloggen
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String naam, @RequestParam String wachtwoord) {
        Gebruiker gebruiker = gebruikerService.zoekGebruikerOpNaam(naam);
        if (gebruiker == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Gebruiker niet gevonden");
        }

        if (passwordEncoder.matches(wachtwoord, gebruiker.getWachtwoord())) {
            // Generate token with user role
            String token = jwtUtil.generateToken(gebruiker.getNaam(), Collections.singletonList(gebruiker.getRole().name()));
            return ResponseEntity.ok(token);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Ongeldig wachtwoord");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<Gebruiker> register(@RequestBody Gebruiker gebruiker) {
        // Versleutel het wachtwoord
        gebruiker.setWachtwoord(passwordEncoder.encode(gebruiker.getWachtwoord()));

        // Sla de gebruiker op
        Gebruiker opgeslagenGebruiker = gebruikerService.saveGebruiker(gebruiker);
        return ResponseEntity.status(HttpStatus.CREATED).body(opgeslagenGebruiker);
    }
}
