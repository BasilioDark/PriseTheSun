package com.SunLovers.PriseTheSun.model;

import jakarta.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name="id")
public class Administrador extends Usuario {
    // Propriedades específicas do administrador
}

