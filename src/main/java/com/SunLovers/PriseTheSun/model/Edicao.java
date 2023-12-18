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
    private String chamadaTrabalhos;
    private LocalDate dataLimiteSubmissao;
    private LocalDate dataDivulgacaoTrabalhos;
    private LocalDate dataEntregaFinal;
    private String informacoesInscricoes;
    private double precoLote1;
    private double precoLote2;
    private String linkInscricoes;
    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;
    @OneToOne
    @JoinColumn(name = "organizador_id")
    private Organizador organizador;
    @OneToMany(mappedBy = "edicao", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Atividade> atividades;


    public Edicao(Long id, int numero, int ano, LocalDate dataInicial, LocalDate dataFinal, String cidade, String chamadaTrabalhos, LocalDate dataLimiteSubmissao, LocalDate dataDivulgacaoTrabalhos, LocalDate dataEntregaFinal, String informacoesInscricoes, double precoLote1, double precoLote2, String linkInscricoes, Organizador organizador, List<Atividade> atividades,  Evento evento) {
        this.id = id;
        this.numero = numero;
        this.ano = ano;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.cidade = cidade;
        this.chamadaTrabalhos = chamadaTrabalhos;
        this.dataLimiteSubmissao = dataLimiteSubmissao;
        this.dataDivulgacaoTrabalhos = dataDivulgacaoTrabalhos;
        this.dataEntregaFinal = dataEntregaFinal;
        this.informacoesInscricoes = informacoesInscricoes;
        this.precoLote1 = precoLote1;
        this.precoLote2 = precoLote2;
        this.linkInscricoes = linkInscricoes;
        this.organizador = organizador;
        this.atividades = atividades;
        this.evento = evento;
        if (!evento.getEdicoes().contains(this)) {
            evento.getEdicoes().add(this);
        }
    }

    public Edicao(){}

    public Edicao(int numero, int ano, LocalDate dataInicial, LocalDate dataFinal, String cidade, String chamadaTrabalhos, LocalDate dataLimiteSubmissao, LocalDate dataDivulgacaoTrabalhos, LocalDate dataEntregaFinal, String informacoesInscricoes, double precoLote1, double precoLote2, String linkInscricoes, Evento evento) {
        this.id = id;
        this.numero = numero;
        this.ano = ano;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.cidade = cidade;
        this.chamadaTrabalhos = chamadaTrabalhos;
        this.dataLimiteSubmissao = dataLimiteSubmissao;
        this.dataDivulgacaoTrabalhos = dataDivulgacaoTrabalhos;
        this.dataEntregaFinal = dataEntregaFinal;
        this.informacoesInscricoes = informacoesInscricoes;
        this.precoLote1 = precoLote1;
        this.precoLote2 = precoLote2;
        this.evento = evento;
        this.linkInscricoes = linkInscricoes;
        if (!evento.getEdicoes().contains(this)) {
            evento.getEdicoes().add(this);
        }

    }

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

    public String getChamadaTrabalhos() {
        return chamadaTrabalhos;
    }

    public void setChamadaTrabalhos(String chamadaTrabalhos) {
        this.chamadaTrabalhos = chamadaTrabalhos;
    }

    public LocalDate getDataLimiteSubmissao() {
        return dataLimiteSubmissao;
    }

    public void setDataLimiteSubmissao(LocalDate dataLimiteSubmissao) {
        this.dataLimiteSubmissao = dataLimiteSubmissao;
    }

    public LocalDate getDataDivulgacaoTrabalhos() {
        return dataDivulgacaoTrabalhos;
    }

    public void setDataDivulgacaoTrabalhos(LocalDate dataDivulgacaoTrabalhos) {
        this.dataDivulgacaoTrabalhos = dataDivulgacaoTrabalhos;
    }

    public LocalDate getDataEntregaFinal() {
        return dataEntregaFinal;
    }

    public void setDataEntregaFinal(LocalDate dataEntregaFinal) {
        this.dataEntregaFinal = dataEntregaFinal;
    }

    public String getInformacoesInscricoes() {
        return informacoesInscricoes;
    }

    public void setInformacoesInscricoes(String informacoesInscricoes) {
        this.informacoesInscricoes = informacoesInscricoes;
    }

    public double getPrecoLote1() {
        return precoLote1;
    }

    public void setPrecoLote1(double precoLote1) {
        this.precoLote1 = precoLote1;
    }

    public double getPrecoLote2() {
        return precoLote2;
    }

    public void setPrecoLote2(double precoLote2) {
        this.precoLote2 = precoLote2;
    }

    public String getLinkInscricoes() {
        return linkInscricoes;
    }

    public void setLinkInscricoes(String linkInscricoes) {
        this.linkInscricoes = linkInscricoes;
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
