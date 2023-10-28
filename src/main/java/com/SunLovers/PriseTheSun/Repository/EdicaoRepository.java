package com.SunLovers.PriseTheSun.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SunLovers.PriseTheSun.model.Edicao;
import com.SunLovers.PriseTheSun.model.Evento;

public interface EdicaoRepository extends JpaRepository<Edicao, Long> {

    List<Edicao> findByEvento(Evento evento);
}