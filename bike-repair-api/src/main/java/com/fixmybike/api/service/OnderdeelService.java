package com.fixmybike.api.service;

import com.fixmybike.api.model.Onderdeel;
import java.util.List;

public interface OnderdeelService {
    Onderdeel addOnderdeel(Onderdeel onderdeel);
    List<Onderdeel> getAllOnderdelen();
}
