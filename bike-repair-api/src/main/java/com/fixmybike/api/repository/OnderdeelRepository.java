package com.fixmybike.api.repository;

import com.fixmybike.api.model.Onderdeel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OnderdeelRepository extends JpaRepository<Onderdeel, Long> {
    // Hier kun je extra methoden toevoegen als je specifieke zoekopdrachten wilt
}
