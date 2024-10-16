package com.fixmybike.api.service;

import com.fixmybike.api.model.Reparatie;
import java.util.List;

public interface ReparatieService {
    Reparatie addReparatie(Reparatie reparatie);
    List<Reparatie> getAllReparaties();
}
