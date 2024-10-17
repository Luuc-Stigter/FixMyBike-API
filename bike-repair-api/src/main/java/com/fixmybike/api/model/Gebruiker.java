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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getTelefoonnummer() {
        return telefoonnummer;
    }

    public void setTelefoonnummer(String telefoonnummer) {
        this.telefoonnummer = telefoonnummer;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Fiets> getFietsen() {
        return fietsen;
    }

    public void setFietsen(List<Fiets> fietsen) {
        this.fietsen = fietsen;
    }
}

