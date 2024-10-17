package com.fixmybike.api.repository;

import com.fixmybike.api.model.Gebruiker;
import com.fixmybike.api.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GebruikerRepository extends JpaRepository<Gebruiker, Long> {
    // Zoek gebruikers op basis van hun rol
    List<Gebruiker> findByRole(Role role);

    // Zoek gebruikers op basis van hun naam
    List<Gebruiker> findByNaamContaining(String naam);

    // Zoek gebruiker op basis van zijn/haar naam
    Gebruiker findByNaam(String naam);
}
