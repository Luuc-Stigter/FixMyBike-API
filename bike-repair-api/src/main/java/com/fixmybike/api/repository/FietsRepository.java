package com.fixmybike.api.repository;

import com.fixmybike.api.model.Fiets;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FietsRepository extends JpaRepository<Fiets, Long> {

}
