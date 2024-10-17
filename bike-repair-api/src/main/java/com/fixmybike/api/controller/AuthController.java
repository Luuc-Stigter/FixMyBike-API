package com.fixmybike.api.controller;

import com.fixmybike.api.model.Gebruiker;
import com.fixmybike.api.service.GebruikerService;
import com.fixmybike.api.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private GebruikerService gebruikerService;

    @Autowired
    private JwtUtil jwtUtil;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    private Set<String> activeTokens = new HashSet<>();

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String naam, @RequestParam String wachtwoord, @RequestHeader(value = "Authorization", required = false) String authorizationHeader) {
        // Check if the user is already logged in
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Er is al een gebruiker ingelogd.");
        }

        Gebruiker gebruiker = gebruikerService.zoekGebruikerOpNaam(naam);
        if (gebruiker == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Gebruiker niet gevonden");
        }

        if (passwordEncoder.matches(wachtwoord, gebruiker.getWachtwoord())) {
            String token = jwtUtil.generateToken(gebruiker.getNaam());
            activeTokens.add(token); // Store the token in the active tokens set
            return ResponseEntity.ok(token);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Ongeldig wachtwoord");
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(@RequestHeader(value = "Authorization") String authorizationHeader) {
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String token = authorizationHeader.substring(7);
            activeTokens.remove(token); // Remove the token from the active tokens set
            return ResponseEntity.ok("Succesvol uitgelogd.");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Geen geldige token gevonden.");
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
