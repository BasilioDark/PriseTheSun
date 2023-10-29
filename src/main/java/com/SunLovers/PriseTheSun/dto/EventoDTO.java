package com.SunLovers.PriseTheSun.dto;

public class EventoDTO {
    private String nome;
    private String sigla;
    private String descricao;

    // Construtores, getters e setters

    @Override
    public String toString() {
        return "EventoDTO{" +
                ", nome='" + nome + '\'' +
                ", sigla='" + sigla + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
