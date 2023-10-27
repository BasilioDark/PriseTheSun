package com.SunLovers.PriseTheSun.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.SunLovers.PriseTheSun.model.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long> {
    // Você pode adicionar métodos de consulta personalizados aqui, se necessário
    boolean existsByNome(String Nome);
}
