package com.SunLovers.PriseTheSun.dto;

public class EventoDTO {
    private String nome;
    private String sigla;
    private String descricao;

    public EventoDTO() {
        // Construtor vazio necessário para o Jackson (biblioteca de serialização/desserialização JSON)
    }

    public EventoDTO(String nome, String sigla, String descricao) {
        this.nome = nome;
        this.sigla = sigla;
        this.descricao = descricao;
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

    @Override
    public String toString() {
        return "EventoDTO{" +
                "nome='" + nome + '\'' +
                ", sigla='" + sigla + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
