package com.SunLovers.PriseTheSun.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String senha;
    @Column(unique = true)
    private String cpf;
    private String email;
    private String filiacao;

    // Construtor vazio
    public Usuario() {
    }

    // Construtor com campos obrigatórios
    public Usuario(String nome, String senha, String cpf, String email, String filiacao) {
        this.nome = nome;
        this.senha = senha;
        this.cpf = cpf;
        this.email = email;
        this.filiacao = filiacao;
    }

    // Getters e Setters

    public Long getId() {
        return id;
    }
       public void setId(long id) {
        this.id = id;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFiliacao() {
        return filiacao;
    }

    public void setFiliacao(String filiacao) {
        this.filiacao = filiacao;
    }

    public void atualizarUsuario(String nome, String senha, String cpf, String email, String filiacao) {
        if (nome != null && !nome.isEmpty()) {
            this.nome = nome;
        }
        if (senha != null && !senha.isEmpty()) {
            this.senha = senha;
        }
        if (cpf != null && !cpf.isEmpty()) {
            this.cpf = cpf;
        }
        if (email != null && !email.isEmpty()) {
            this.email = email;
        }
        if (filiacao != null && !filiacao.isEmpty()) {
            this.filiacao = filiacao;
        }
    }

    // Método para validar a senha
    public boolean validarSenha(String senhaDigitada) {
        return this.senha.equals(senhaDigitada);
    }

    // Método para atualizar informações do usuário

    // Método para criptografar a senha (você pode implementar isso usando
    // bibliotecas de criptografia)
    public void criptografarSenha() {
        // Implemente a lógica para criptografar a senha aqui
    }
}
