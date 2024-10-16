package com.fixmybike.api.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Gebruiker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String naam;
    private String telefoonnummer;
    private String adres;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "gebruiker")
    private List<Fiets> fietsen;

    // Getters en setters
}

