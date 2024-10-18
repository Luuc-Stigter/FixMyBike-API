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
        return reparatieRepository.save(reparatie);
    }

    public List<Reparatie> getAllReparaties() {
        return reparatieRepository.findAll();
    }

    public Reparatie scheduleKeuring(Reparatie reparatie) {
        return reparatieRepository.save(reparatie);
    }
}
