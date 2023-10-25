package com.SunLovers.PriseTheSun.model;
import java.io.Serializable;

import jakarta.persistence.*;


@Entity
@Table(name = "usuarios")
@Inheritance(strategy = InheritanceType. JOINED)
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //private String nome;
    //private String Senha; // verificar possibilidade de criptografar

    // Getters e Setters
}