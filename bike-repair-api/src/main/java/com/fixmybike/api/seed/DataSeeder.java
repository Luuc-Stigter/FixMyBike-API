package com.fixmybike.api.seed;

import com.fixmybike.api.model.Factuur;
import com.fixmybike.api.model.Fiets;
import com.fixmybike.api.model.Gebruiker;
import com.fixmybike.api.model.Onderdeel;
import com.fixmybike.api.model.Reparatie;
import com.fixmybike.api.repository.FactuurRepository;
import com.fixmybike.api.repository.FietsRepository;
import com.fixmybike.api.repository.GebruikerRepository;
import com.fixmybike.api.repository.OnderdeelRepository;
import com.fixmybike.api.repository.ReparatieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Component
public class DataSeeder implements CommandLineRunner {

    @Autowired
    private GebruikerRepository gebruikerRepository;

    @Autowired
    private FietsRepository fietsRepository;

    @Autowired
    private ReparatieRepository reparatieRepository;

    @Autowired
    private OnderdeelRepository onderdeelRepository;

    @Autowired
    private FactuurRepository factuurRepository;

    @Override
    public void run(String... args) throws Exception {
        seedGebruikers();
        seedFietsen();
        seedOnderdelen();
        seedReparaties();
        seedFacturen();
    }

    private void seedGebruikers() {
        if (gebruikerRepository.count() == 0) {
            Gebruiker gebruiker1 = new Gebruiker();
            gebruiker1.setNaam("Jan Jansen");
            gebruiker1.setTelefoonnummer("0612345678");
            gebruiker1.setAdres("Hoofdstraat 1, Amsterdam");
            gebruiker1.setRole(Role.FIETSTECHNICUS);

            Gebruiker gebruiker2 = new Gebruiker();
            gebruiker2.setNaam("Piet Pietersen");
            gebruiker2.setTelefoonnummer("0687654321");
            gebruiker2.setAdres("Bijstraat 2, Rotterdam");
            gebruiker2.setRole(Role.BALIEPERSONEEL);

            gebruikerRepository.saveAll(Arrays.asList(gebruiker1, gebruiker2));
        }
    }

    private void seedFietsen() {
        if (fietsRepository.count() == 0) {
            Gebruiker gebruiker = gebruikerRepository.findById(1L).orElse(null); // Voorbeeld gebruiker

            Fiets fiets1 = new Fiets();
            fiets1.setMerk("Gazelle");
            fiets1.setModel("Chamonix");
            fiets1.setSerienummer("SN123456");
            fiets1.setGebruiker(gebruiker);

            Fiets fiets2 = new Fiets();
            fiets2.setMerk("Batavus");
            fiets2.setModel("Dynamo");
            fiets2.setSerienummer("SN654321");
            fiets2.setGebruiker(gebruiker);

            fietsRepository.saveAll(Arrays.asList(fiets1, fiets2));
        }
    }

    private void seedOnderdelen() {
        if (onderdeelRepository.count() == 0) {
            Onderdeel onderdeel1 = new Onderdeel();
            onderdeel1.setNaam("Band");
            onderdeel1.setPrijs(15.50f);
            onderdeel1.setVoorraad(100);

            Onderdeel onderdeel2 = new Onderdeel();
            onderdeel2.setNaam("Remblok");
            onderdeel2.setPrijs(25.00f);
            onderdeel2.setVoorraad(50);

            onderdeelRepository.saveAll(Arrays.asList(onderdeel1, onderdeel2));
        }
    }

    private void seedReparaties() {
        if (reparatieRepository.count() == 0) {
            Fiets fiets = fietsRepository.findById(1L).orElse(null); // Voorbeeld fiets
            Gebruiker technicus = gebruikerRepository.findById(1L).orElse(null); // Voorbeeld technicus

            Reparatie reparatie = new Reparatie();
            reparatie.setStatus("In behandeling");
            reparatie.setDatum(LocalDateTime.now());
            reparatie.setFiets(fiets);
            reparatie.setTechnicus(technicus);

            reparatieRepository.save(reparatie);
        }
    }

    private void seedFacturen() {
        if (factuurRepository.count() == 0) {
            Reparatie reparatie = reparatieRepository.findById(1L).orElse(null); // Voorbeeld reparatie

            Factuur factuur = new Factuur();
            factuur.setBtwTarief(21.0f);
            factuur.setTotaalBedrag(100.0f); // Dit kan worden berekend op basis van de reparatie en onderdelen
            factuur.setReparatie(reparatie);

            factuurRepository.save(factuur);
        }
    }
}

