package com.fixmybike.api.service;

import com.fixmybike.api.model.Fiets;
import com.fixmybike.api.repository.FietsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FietsService {

    @Autowired
    private FietsRepository fietsRepository;

    public Fiets registerFiets(Fiets fiets) {
        // Logica voor fietsregistratie, zoals validatie
        return fietsRepository.save(fiets);
    }

    public List<Fiets> getAllFietsen() {
        return fietsRepository.findAll();
    }

    // Voeg meer methoden toe indien nodig
}