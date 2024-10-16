package com.fixmybike.api.repository;

import com.fixmybike.api.model.Reparatie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReparatieRepository extends JpaRepository<Reparatie, Long> {
    // Hier kun je extra methoden toevoegen als je specifieke zoekopdrachten wilt
}
