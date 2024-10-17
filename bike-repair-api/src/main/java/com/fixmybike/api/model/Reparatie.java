package com.fixmybike.api.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Reparatie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;
    private LocalDateTime datum;

    @ManyToOne
    @JoinColumn(name = "fiets_id")
    private Fiets fiets;

    @ManyToOne
    @JoinColumn(name = "technicus_id")
    private Gebruiker technicus;

    @OneToOne(mappedBy = "reparatie", cascade = CascadeType.ALL)
    private Factuur factuur;

    @ManyToMany
    @JoinTable(
            name = "reparatie_onderdeel",
            joinColumns = @JoinColumn(name = "reparatie_id"),
            inverseJoinColumns = @JoinColumn(name = "onderdeel_id")
    )
    private List<Onderdeel> onderdelen;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getDatum() {
        return datum;
    }

    public void setDatum(LocalDateTime datum) {
        this.datum = datum;
    }

    public Fiets getFiets() {
        return fiets;
    }

    public void setFiets(Fiets fiets) {
        this.fiets = fiets;
    }

    public Gebruiker getTechnicus() {
        return technicus;
    }

    public void setTechnicus(Gebruiker technicus) {
        this.technicus = technicus;
    }

    public Factuur getFactuur() {
        return factuur;
    }

    public void setFactuur(Factuur factuur) {
        this.factuur = factuur;
    }

    public List<Onderdeel> getOnderdelen() {
        return onderdelen;
    }

    public void setOnderdelen(List<Onderdeel> onderdelen) {
        this.onderdelen = onderdelen;
    }
}
