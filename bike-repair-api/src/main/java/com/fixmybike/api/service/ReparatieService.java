package com.fixmybike.api.service;

import com.fixmybike.api.model.Reparatie;
import com.fixmybike.api.repository.ReparatieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReparatieService {

    @Autowired
    private ReparatieRepository reparatieRepository;

    public Reparatie addReparatie(Reparatie reparatie) {
        // Logica voor het toevoegen van een reparatie
        return reparatieRepository.save(reparatie);
    }

    public List<Reparatie> getAllReparaties() {
        return reparatieRepository.findAll();
    }

    // Voeg meer methoden toe indien nodig
}
