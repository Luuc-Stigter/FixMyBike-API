package com.fixmybike.api.service;

import com.fixmybike.api.model.Fiets;
import java.util.List;

public interface FietsService {
    Fiets registerFiets(Fiets fiets);
    List<Fiets> getAllFietsen();
}
