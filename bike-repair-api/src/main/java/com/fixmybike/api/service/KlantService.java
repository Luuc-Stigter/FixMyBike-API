package com.fixmybike.api.service;

import com.fixmybike.api.model.Gebruiker;
import java.util.List;

public interface KlantService {
    Gebruiker registerKlant(Gebruiker klant);
    List<Gebruiker> getAllKlanten();
}
