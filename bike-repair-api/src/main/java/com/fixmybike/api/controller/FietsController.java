package com.fixmybike.api.controller;

import com.fixmybike.api.model.Fiets;
import com.fixmybike.api.model.Reparatie;
import com.fixmybike.api.service.FietsService;
import com.fixmybike.api.service.ReparatieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fietsen")
public class FietsController {

    @Autowired
    private FietsService fietsService;

    @Autowired
    private ReparatieService reparatieService; // Autowire ReparatieService

    // Endpoint voor het registreren van een fiets
    @PostMapping
    public ResponseEntity<Fiets> registerFiets(@RequestBody Fiets fiets) {
        Fiets createdFiets = fietsService.registerFiets(fiets);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFiets); // Use 201 Created
    }

    // Endpoint voor het ophalen van alle fietsen
    @GetMapping
    public ResponseEntity<List<Fiets>> getAllFietsen() {
        List<Fiets> fietsen = fietsService.getAllFietsen();
        return ResponseEntity.ok(fietsen);
    }

    // Endpoint voor het inplannen van een keuring
    @PostMapping("/{fietsId}/keuring")
    public ResponseEntity<Reparatie> scheduleKeuring(@PathVariable Long fietsId, @RequestBody Reparatie reparatie) {
        Fiets fiets = fietsService.getFietsById(fietsId);
        if (fiets == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        reparatie.setFiets(fiets);
        Reparatie scheduledReparatie = reparatieService.scheduleKeuring(reparatie);
        return ResponseEntity.status(HttpStatus.CREATED).body(scheduledReparatie);
    }
}
