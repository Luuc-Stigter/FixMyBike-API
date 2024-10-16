package com.fixmybike.api.model;

import jakarta.persistence.*;

@Entity
public class Factuur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Float btwTarief;
    private Float totaalBedrag;

    @OneToOne
    @JoinColumn(name = "reparatie_id")
    private Reparatie reparatie;

    // Getters en setters
}
