package com.fixmybike.api.controller;

import com.fixmybike.api.model.Fiets;
import com.fixmybike.api.service.FietsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fietsen")
public class FietsController {

    @Autowired
    private FietsService fietsService;

    @PostMapping
    public ResponseEntity<Fiets> registerFiets(@RequestBody Fiets fiets) {
        Fiets createdFiets = fietsService.registerFiets(fiets);
        return ResponseEntity.ok(createdFiets);
    }

    @GetMapping
    public ResponseEntity<List<Fiets>> getAllFietsen() {
        List<Fiets> fietsen = fietsService.getAllFietsen();
        return ResponseEntity.ok(fietsen);
    }
}
