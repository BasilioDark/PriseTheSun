package com.SunLovers.PriseTheSun.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "Edicao", uniqueConstraints = @UniqueConstraint(columnNames = {"ano", "evento_id"}))
public class Edicao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int numero;
    private int ano;
    private LocalDate dataInicial;
    private LocalDate dataFinal;
    private String cidade;
    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;
    @OneToOne
    @JoinColumn(name = "organizador_id")
    private Organizador organizador;
    @OneToMany(mappedBy = "edicao", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Atividade> atividades;

    

    public Edicao(int numero, int ano, LocalDate dataInicial, LocalDate dataFinal, String cidade, Evento evento) {
        this.numero = numero;
        this.ano = ano;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.cidade = cidade;
        this.evento = evento;
        if (!evento.getEdicoes().contains(this)) {
            evento.getEdicoes().add(this);
        }
    }
    Edicao(){}
    
    public Organizador getOrganizador() {
        return this.organizador;
    }
    public void setOrganizador(Organizador organizador) {
        this.organizador = organizador;
    }
    public Long getId() {
        return id;
    }

    public int getNumero() {
        return numero;
    }

    public int getAno() {
        return ano;
    }

    public LocalDate getDataInicial() {
        return dataInicial;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public String getCidade() {
        return cidade;
    }

    public void atualizarEdicao(String numero, String ano, LocalDate dataInicial, LocalDate dataFinal, String cidade) {
        if (numero != null && !numero.isEmpty()) {
            this.numero = Integer.parseInt(numero);
        }
        if (ano != null && !ano.isEmpty()) {
            this.ano = Integer.parseInt(ano);
        }
        if (dataInicial != null) {
            this.dataInicial = dataInicial;
        }
        if (dataFinal != null) {
            this.dataFinal = dataFinal;
        }
        if (cidade != null && !cidade.isEmpty()) {
            this.cidade = cidade;
        }
    }
}
