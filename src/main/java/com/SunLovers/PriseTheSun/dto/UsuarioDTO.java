package com.SunLovers.PriseTheSun.dto;

public class UsuarioDTO {

    private String nome;
    private String senha;
    private String cpf;
    private String email;
    private String filiacao;

    // Construtor vazio
    public UsuarioDTO() {
    }

    // Construtor com campos obrigatórios
    public UsuarioDTO(String nome, String senha, String cpf, String email, String filiacao) {
        this.nome = nome;
        this.senha = senha;
        this.cpf = cpf;
        this.email = email;
        this.filiacao = filiacao;
    }

    // Getters e Setters

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

    @Override
    public String toString() {
        return "UsuarioDTO{" +
                "nome='" + nome + '\'' +
                ", senha='" + senha + '\'' +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                ", filiacao='" + filiacao + '\'' +
                '}';
    }
}
