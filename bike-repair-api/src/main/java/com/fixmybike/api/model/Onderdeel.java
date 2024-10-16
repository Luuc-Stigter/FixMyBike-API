package com.fixmybike.api.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Onderdeel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String naam;
    private Float prijs;
    private int voorraad;

    @ManyToMany(mappedBy = "onderdelen")
    private List<Reparatie> reparaties;

    // Getters en setters
}
