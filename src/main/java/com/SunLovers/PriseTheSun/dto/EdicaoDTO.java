package com.SunLovers.PriseTheSun.dto;

import java.time.LocalDate;

public class EdicaoDTO {

    private int numero;
    private int ano;
    private LocalDate dataInicial;
    private LocalDate dataFinal;
    private String cidade;

    // Construtores, getters e setters

    public EdicaoDTO() {
        // Construtor vazio necessário para deserialização JSON
    }

    public EdicaoDTO(int numero, int ano, LocalDate dataInicial, LocalDate dataFinal, String cidade) {
        this.numero = numero;
        this.ano = ano;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.cidade = cidade;
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
