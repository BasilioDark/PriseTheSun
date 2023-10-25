package com.SunLovers.PriseTheSun.model;
import jakarta.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name="id")
public class Organizador extends Usuario {
    // Propriedades específicas do organizador
}