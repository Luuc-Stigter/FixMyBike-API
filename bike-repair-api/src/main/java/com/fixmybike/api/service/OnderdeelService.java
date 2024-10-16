package com.fixmybike.api.service;

import com.fixmybike.api.model.Onderdeel;
import com.fixmybike.api.repository.OnderdeelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OnderdeelService {

    @Autowired
    private OnderdeelRepository onderdeelRepository;

    public Onderdeel addOnderdeel(Onderdeel onderdeel) {
        // Logica voor het toevoegen van een onderdeel
        return onderdeelRepository.save(onderdeel);
    }

    public List<Onderdeel> getAllOnderdelen() {
        return onderdeelRepository.findAll();
    }

    // Voeg meer methoden toe indien nodig
}
