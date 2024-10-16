package com.fixmybike.api.service;

import com.fixmybike.api.model.Gebruiker;
import com.fixmybike.api.repository.GebruikerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KlantService {

    @Autowired
    private GebruikerRepository gebruikerRepository;

    public Gebruiker registerKlant(Gebruiker klant) {
        // Logica voor klantregistratie, zoals validatie
        return gebruikerRepository.save(klant);
    }

    public List<Gebruiker> getAllKlanten() {
        return gebruikerRepository.findAll();
    }

    // Voeg meer methoden toe indien nodig
}
