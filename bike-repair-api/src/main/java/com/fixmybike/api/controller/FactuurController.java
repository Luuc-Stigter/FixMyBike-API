package com.fixmybike.api.controller;

import com.fixmybike.api.model.Factuur;
import com.fixmybike.api.service.FactuurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/facturen")
public class FactuurController {

    @Autowired
    private FactuurService factuurService;

    @PostMapping
    public ResponseEntity<Factuur> generateFactuur(@RequestBody Factuur factuur) {
        Factuur createdFactuur = factuurService.generateFactuur(factuur);
        return ResponseEntity.ok(createdFactuur);
    }

    @GetMapping
    public ResponseEntity<List<Factuur>> getAllFacturen() {
        List<Factuur> facturen = factuurService.getAllFacturen();
        return ResponseEntity.ok(facturen);
    }
}
