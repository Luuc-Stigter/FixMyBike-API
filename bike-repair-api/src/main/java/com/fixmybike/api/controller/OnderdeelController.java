package com.fixmybike.api.controller;

import com.fixmybike.api.model.Onderdeel;
import com.fixmybike.api.service.OnderdeelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/onderdelen")
public class OnderdeelController {

    @Autowired
    private OnderdeelService OnderdeelService;

    @PostMapping
    public ResponseEntity<Onderdeel> addOnderdeel(@RequestBody Onderdeel onderdeel) {
        Onderdeel createdOnderdeel = OnderdeelService.addOnderdeel(onderdeel);
        return ResponseEntity.ok(createdOnderdeel);
    }

    @GetMapping
    public ResponseEntity<List<Onderdeel>> getAllOnderdelen() {
        List<Onderdeel> onderdelen = OnderdeelService.getAllOnderdelen();
        return ResponseEntity.ok(onderdelen);
    }
}
