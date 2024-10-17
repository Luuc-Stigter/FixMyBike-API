package com.fixmybike.api.service;

import com.fixmybike.api.model.Gebruiker;
import com.fixmybike.api.model.Role;
import com.fixmybike.api.repository.GebruikerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GebruikerService {

    private final GebruikerRepository gebruikerRepository;

    @Autowired
    public GebruikerService(GebruikerRepository gebruikerRepository) {
        this.gebruikerRepository = gebruikerRepository;
    }

    // Haal alle gebruikers op
    public List<Gebruiker> getAllGebruikers() {
        return gebruikerRepository.findAll();
    }

    // Haal een specifieke gebruiker op op basis van ID
    public Gebruiker getGebruikerById(Long id) {
        return gebruikerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Gebruiker niet gevonden met ID: " + id));
    }

    // Maak een nieuwe gebruiker aan of update een bestaande gebruiker
    public Gebruiker saveGebruiker(Gebruiker gebruiker) {
        return gebruikerRepository.save(gebruiker);
    }

    // Verwijder een gebruiker op basis van ID
    public void deleteGebruiker(Long id) {
        gebruikerRepository.deleteById(id);
    }

    // Zoek gebruikers op basis van hun rol
    public List<Gebruiker> getGebruikersByRole(Role role) {
        return gebruikerRepository.findByRole(role);
    }

    // Zoek gebruiker op basis van exacte naam
    public Gebruiker zoekGebruikerOpNaam(String naam) {
        return gebruikerRepository.findByNaam(naam)
                .orElseThrow(() -> new RuntimeException("Gebruiker niet gevonden met naam: " + naam));
    }

}
