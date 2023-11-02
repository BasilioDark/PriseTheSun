package com.SunLovers.PriseTheSun.model;
import jakarta.persistence.CascadeType;
import jakarta.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name="id")
public class Organizador extends Usuario {
    @OneToOne(mappedBy = "organizador", cascade = CascadeType.ALL, orphanRemoval = true)
    private Edicao edicao;
    public Organizador(){}
    public Organizador(Usuario usuario) {
        super(usuario); 
    }
    public void setEdicao(Edicao edicao) {
        this.edicao = edicao;
        this.edicao.setOrganizador(this);
    }
    public Edicao getEdicao() {
        return edicao;
    }
    // Propriedades específicas do organizador
}