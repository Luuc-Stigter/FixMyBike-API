package com.fixmybike.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private List<Reparatie> reparaties;

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

    public Float getPrijs() {
        return prijs;
    }

    public void setPrijs(Float prijs) {
        this.prijs = prijs;
    }

    public int getVoorraad() {
        return voorraad;
    }

    public void setVoorraad(int voorraad) {
        this.voorraad = voorraad;
    }

    public List<Reparatie> getReparaties() {
        return reparaties;
    }

    public void setReparaties(List<Reparatie> reparaties) {
        this.reparaties = reparaties;
    }
}
