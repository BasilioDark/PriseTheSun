package com.SunLovers.PriseTheSun.model;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name="id")
public class Organizador extends Usuario {
        @OneToMany(mappedBy = "organizador", cascade = CascadeType.ALL)
    private List<Edicao> edicoesOrganizadas = new ArrayList<>();
    public Organizador(){}
    public Organizador(Usuario usuario) {
        super(usuario.getNome(), usuario.getSenha(), usuario.getCpf(), usuario.getEmail(), usuario.getFiliacao());
        super.setId(usuario.getId());
        System.out.println(this.getId());
    }
    // Propriedades específicas do organizador
}