package com.fixmybike.api.repository;

import com.fixmybike.api.model.Factuur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FactuurRepository extends JpaRepository<Factuur, Long> {
    // Hier kun je extra methoden toevoegen als je specifieke zoekopdrachten wilt
}
