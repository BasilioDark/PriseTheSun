package com.SunLovers.PriseTheSun.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.*;
@Entity
@Table(name = "Evento")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String sigla;
    private String descricao;

    // Relacionamento OneToMany com Edicao
    @OneToMany(mappedBy = "evento", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Edicao> edicoes;

    public Evento(String nome, String sigla, String descricao) {
        this.nome = nome;
        this.sigla = sigla;
        this.descricao = descricao;
        this.edicoes = new ArrayList<>(); 
    }
    public Evento() {}   
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getSigla() {
        return sigla;
    }

    public String getDescricao() {
        return descricao;
    }

    // Métodos get e set para a lista de Edicao
    public List<Edicao> getEdicoes() {
        return edicoes;
    }

    public void setEdicoes(List<Edicao> edicoes) {
        this.edicoes = edicoes;
    }

    public void atualizar(String nome, String sigla, String descricao) {
        if (nome != null && !nome.isEmpty()) {
            this.nome = nome;
        }
        if (sigla != null && !sigla.isEmpty()) {
            this.sigla = sigla;
        }
        if (descricao != null && !descricao.isEmpty()) {
            this.descricao = descricao;
        }
    }
    // Getters and setters
}
