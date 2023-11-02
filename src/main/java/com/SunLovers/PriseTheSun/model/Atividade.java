package com.SunLovers.PriseTheSun.model;

import jakarta.persistence.*;
import java.util.Date;
import java.sql.Time;

@Entity
public class Atividade {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String nome;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoAtividade tipo;
    
    @Column(nullable = false)
    private String descricao;
    
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date data;
    
    @Column(nullable = false)
    private Time horarioInicial;
    
    @Column(nullable = false)
    private Time horarioFinal;

    @ManyToOne
    @JoinColumn(name = "edicao_id")
    private Edicao edicao;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoAtividade getTipo() {
        return tipo;
    }

    public void setTipo(TipoAtividade tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Time getHorarioInicial() {
        return horarioInicial;
    }

    public void setHorarioInicial(Time horarioInicial) {
        this.horarioInicial = horarioInicial;
    }

    public Time getHorarioFinal() {
        return horarioFinal;
    }

    public void setHorarioFinal(Time horarioFinal) {
        this.horarioFinal = horarioFinal;
    }

    public Edicao getEdicao() {
        return edicao;
    }

    public void setEdicao(Edicao edicao) {
        this.edicao = edicao;
    }
    
    // Construtores
    // ...

    public enum TipoAtividade {
        TIPO1,
        TIPO2,
        TIPO3;
        // Adicione mais tipos conforme necessário
    }
}