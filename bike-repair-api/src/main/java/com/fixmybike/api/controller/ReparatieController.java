package com.fixmybike.api.controller;

import com.fixmybike.api.model.Reparatie;
import com.fixmybike.api.service.ReparatieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reparaties")
public class ReparatieController {

    @Autowired
    private ReparatieService reparatieService;

    // Endpoint voor het toevoegen van een reparatie
    @PostMapping
    public ResponseEntity<Reparatie> addReparatie(@RequestBody Reparatie reparatie) {
        Reparatie createdReparatie = reparatieService.addReparatie(reparatie);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdReparatie); // Use 201 Created
    }

    // Endpoint voor het ophalen van alle reparaties
    @GetMapping
    public ResponseEntity<List<Reparatie>> getAllReparaties() {
        List<Reparatie> reparaties = reparatieService.getAllReparaties();
        return ResponseEntity.ok(reparaties);
    }
}
