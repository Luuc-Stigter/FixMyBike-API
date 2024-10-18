package com.fixmybike.api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @JsonBackReference
    private Reparatie reparatie;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getBtwTarief() {
        return btwTarief;
    }

    public void setBtwTarief(Float btwTarief) {
        this.btwTarief = btwTarief;
    }

    public Float getTotaalBedrag() {
        return totaalBedrag;
    }

    public void setTotaalBedrag(Float totaalBedrag) {
        this.totaalBedrag = totaalBedrag;
    }

    public Reparatie getReparatie() {
        return reparatie;
    }

    public void setReparatie(Reparatie reparatie) {
        this.reparatie = reparatie;
    }
}
