package com.fixmybike.api.service;

import com.fixmybike.api.model.Factuur;

public interface FactuurService {
    Factuur generateFactuur(Long reparatieId);
}
