package com.fixmybike.api.controller;

import com.fixmybike.api.model.Gebruiker;
import com.fixmybike.api.service.KlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/klanten")
public class KlantController {

    @Autowired
    private KlantService klantService;

    @PostMapping
    public ResponseEntity<Gebruiker> registerKlant(@RequestBody Gebruiker klant) {
        Gebruiker createdKlant = klantService.registerKlant(klant);
        return ResponseEntity.ok(createdKlant);
    }

    @GetMapping
    public ResponseEntity<List<Gebruiker>> getAllKlanten() {
        List<Gebruiker> klanten = klantService.getAllKlanten();
        return ResponseEntity.ok(klanten);
    }
}
