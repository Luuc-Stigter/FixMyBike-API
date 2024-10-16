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

    // Getters en setters
}
