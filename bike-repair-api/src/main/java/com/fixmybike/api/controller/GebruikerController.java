package com.fixmybike.api.controller;

import com.fixmybike.api.model.Gebruiker;
import com.fixmybike.api.model.Role;
import com.fixmybike.api.service.GebruikerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gebruikers")
public class GebruikerController {

    private final GebruikerService gebruikerService;

    public GebruikerController(GebruikerService gebruikerService) {
        this.gebruikerService = gebruikerService;
    }

    // Endpoint om alle gebruikers op te halen
    @GetMapping
    public ResponseEntity<List<Gebruiker>> getAllGebruikers() {
        List<Gebruiker> gebruikers = gebruikerService.getAllGebruikers();
        return ResponseEntity.ok(gebruikers);
    }

    // Endpoint om een specifieke gebruiker op te halen
    @GetMapping("/{id}")
    public ResponseEntity<Gebruiker> getGebruikerById(@PathVariable Long id) {
        Gebruiker gebruiker = gebruikerService.getGebruikerById(id);
        return ResponseEntity.ok(gebruiker);
    }

    // Endpoint om een nieuwe gebruiker aan te maken
    @PostMapping
    public ResponseEntity<Gebruiker> createGebruiker(@RequestBody Gebruiker gebruiker) {
        gebruikerService.saveGebruiker(gebruiker);
        return ResponseEntity.status(HttpStatus.CREATED).body(gebruiker);
    }

    // Endpoint om een bestaande gebruiker te updaten
    @PutMapping("/{id}")
    public ResponseEntity<Gebruiker> updateGebruiker(@PathVariable Long id, @RequestBody Gebruiker gebruikerDetails) {
        Gebruiker updatedGebruiker = gebruikerService.getGebruikerById(id);
        updatedGebruiker.setNaam(gebruikerDetails.getNaam());
        updatedGebruiker.setTelefoonnummer(gebruikerDetails.getTelefoonnummer());
        updatedGebruiker.setAdres(gebruikerDetails.getAdres());
        updatedGebruiker.setRole(gebruikerDetails.getRole());

        gebruikerService.saveGebruiker(updatedGebruiker);
        return ResponseEntity.ok(updatedGebruiker);
    }

    // Endpoint om een gebruiker te verwijderen
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGebruiker(@PathVariable Long id) {
        gebruikerService.deleteGebruiker(id);
        return ResponseEntity.noContent().build();
    }

    // Endpoint om gebruikers op rol te zoeken
    @GetMapping("/role/{role}")
    public ResponseEntity<List<Gebruiker>> getGebruikersByRole(@PathVariable Role role) {
        List<Gebruiker> gebruikers = gebruikerService.getGebruikersByRole(role);
        return ResponseEntity.ok(gebruikers);
    }

    // Endpoint om gebruikers op naam te zoeken
    @GetMapping("/search")
    public ResponseEntity<List<Gebruiker>> searchGebruikers(@RequestParam String naam) {
        List<Gebruiker> gebruikers = gebruikerService.zoekGebruikersOpNaam(naam);
        return ResponseEntity.ok(gebruikers);
    }
}
