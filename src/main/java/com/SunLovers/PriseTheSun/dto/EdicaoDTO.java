package com.SunLovers.PriseTheSun.dto;

import java.time.LocalDate;

public class EdicaoDTO {

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

    // Construtores, getters e setters

    public EdicaoDTO() {
        // Construtor vazio necessário para deserialização JSON
    }

    public EdicaoDTO(int numero, int ano, LocalDate dataInicial, LocalDate dataFinal, String cidade, String chamadaTrabalhos, LocalDate dataLimiteSubmissao, LocalDate dataDivulgacaoTrabalhos, LocalDate dataEntregaFinal, String informacoesInscricoes, double precoLote1, double precoLote2, String linkInscricoes) {
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
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public LocalDate getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(LocalDate dataInicial) {
        this.dataInicial = dataInicial;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(LocalDate dataFinal) {
        this.dataFinal = dataFinal;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
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



    @Override
public String toString() {
    return "EdicaoDTO{" +
           "numero=" + numero +
           ", ano=" + ano +
           ", dataInicial=" + dataInicial +
           ", dataFinal=" + dataFinal +
           ", cidade='" + cidade + '\'' +
           '}';
}
}
