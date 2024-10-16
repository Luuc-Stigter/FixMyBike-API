package com.fixmybike.api.repository;

import com.fixmybike.api.model.Gebruiker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GebruikerRepository extends JpaRepository<Gebruiker, Long> {

}
