package com.SunLovers.PriseTheSun.dto;

import com.SunLovers.PriseTheSun.model.Atividade;
import com.SunLovers.PriseTheSun.model.Atividade.TipoAtividade;

public class AtividadeDTO {
    private Long id;
    private String nome;
    private TipoAtividade tipo;

    private String data;
    private String horarioInicial;
    private String horarioFinal;

    public AtividadeDTO(Atividade atividade) {
        this.id = atividade.getId();
        this.nome = atividade.getNome();
        this.tipo = atividade.getTipo();
        this.data = atividade.getData().toString();
        this.horarioInicial = atividade.getHorarioInicial().toString();
        this.horarioFinal = atividade.getHorarioFinal().toString();
    }

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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHorarioInicial() {
        return horarioInicial;
    }

    public void setHorarioInicial(String horarioInicial) {
        this.horarioInicial = horarioInicial;
    }

    public String getHorarioFinal() {
        return horarioFinal;
    }

    public void setHorarioFinal(String horarioFinal) {
        this.horarioFinal = horarioFinal;
    }
}
