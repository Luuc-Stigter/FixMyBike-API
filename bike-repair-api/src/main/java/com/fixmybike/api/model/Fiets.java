package com.fixmybike.api.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Fiets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String merk;
    private String model;
    private String serienummer;

    @ManyToOne
    @JoinColumn(name = "gebruiker_id")
    private Gebruiker gebruiker;

    @OneToMany(mappedBy = "fiets")
    private List<Reparatie> reparaties;

    // Getters en setters
}
