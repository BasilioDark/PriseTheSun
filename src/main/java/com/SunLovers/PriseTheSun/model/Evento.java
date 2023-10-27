package com.SunLovers.PriseTheSun.model;

import jakarta.persistence.*;
import java.util.List;
@Entity
@Table(name = "Evento")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "sigla")
    private String sigla;

    @Column(name = "descricao")
    private String descricao;

    // Relacionamento OneToMany com Edicao
    @OneToMany(mappedBy = "evento", cascade = CascadeType.ALL)
    private List<Edicao> edicoes;

    public Evento(String nome, String sigla, String descricao) {
        this.nome = nome;
        this.sigla = sigla;
        this.descricao = descricao;
    }

    // Getters and setters
}
