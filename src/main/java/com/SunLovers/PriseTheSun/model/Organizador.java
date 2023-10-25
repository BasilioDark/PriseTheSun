package com.SunLovers.PriseTheSun.model;
import jakarta.persistence.*;

@Entity
@DiscriminatorValue("ORGANIZADOR")
public class Organizador extends Usuario {
    // Propriedades específicas do organizador
}