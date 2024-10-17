package com.fixmybike.api.controller;

import com.fixmybike.api.model.Gebruiker;
import com.fixmybike.api.service.GebruikerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private GebruikerService gebruikerService;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // Endpoint voor inloggen
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String naam, @RequestParam String wachtwoord) {
        // Zoek gebruiker op naam
        Gebruiker gebruiker = gebruikerService.zoekGebruikerOpNaam(naam);
        if (gebruiker == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Gebruiker niet gevonden");
        }

        // Valideer het wachtwoord
        if (passwordEncoder.matches(wachtwoord, gebruiker.getWachtwoord())) {
            return ResponseEntity.ok("Inloggen geslaagd");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Ongeldig wachtwoord");
        }
    }

    // Endpoint voor registratie (optioneel)
    @PostMapping("/register")
    public ResponseEntity<Gebruiker> register(@RequestBody Gebruiker gebruiker) {
        // Versleutel het wachtwoord
        gebruiker.setWachtwoord(passwordEncoder.encode(gebruiker.getWachtwoord()));

        // Sla de gebruiker op
        Gebruiker opgeslagenGebruiker = gebruikerService.saveGebruiker(gebruiker);
        return ResponseEntity.status(HttpStatus.CREATED).body(opgeslagenGebruiker);
    }
}
