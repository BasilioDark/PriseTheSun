package com.SunLovers.PriseTheSun.model;
import java.time.LocalDate;


import jakarta.persistence.*;

@Entity
@Table(name = "Edicao")
public class Edicao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero")
    private int numero;

    @Column(name = "ano")
    private int ano;

    @Column(name = "data_inicial")
    private LocalDate dataInicial;

    @Column(name = "data_final")
    private LocalDate dataFinal;

    @Column(name = "cidade")
    private String cidade;

    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;

    // Getters and setters
}
