package com.fixmybike.api.service;

import com.fixmybike.api.model.Factuur;
import com.fixmybike.api.repository.FactuurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FactuurService {

    @Autowired
    private FactuurRepository factuurRepository;

    public Factuur generateFactuur(Factuur factuur) {
        // Logica voor het genereren van een factuur
        return factuurRepository.save(factuur);
    }

    public List<Factuur> getAllFacturen() {
        return factuurRepository.findAll();
    }

    // Voeg meer methoden toe indien nodig
}
