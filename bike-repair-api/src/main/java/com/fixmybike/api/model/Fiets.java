package com.fixmybike.api.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
    @JsonIgnore
    private Gebruiker gebruiker;

    @OneToMany(mappedBy = "fiets")
    @JsonManagedReference
    private List<Reparatie> reparaties;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSerienummer() {
        return serienummer;
    }

    public void setSerienummer(String serienummer) {
        this.serienummer = serienummer;
    }

    public Gebruiker getGebruiker() {
        return gebruiker;
    }

    public void setGebruiker(Gebruiker gebruiker) {
        this.gebruiker = gebruiker;
    }

    public List<Reparatie> getReparaties() {
        return reparaties;
    }

    public void setReparaties(List<Reparatie> reparaties) {
        this.reparaties = reparaties;
    }
}
