package com.SunLovers.PriseTheSun.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SunLovers.PriseTheSun.model.Edicao;

public interface EdicaoRepository extends JpaRepository<Edicao, Long> {
    // Você pode adicionar métodos de consulta personalizados aqui, se necessário
}
