package com.SunLovers.PriseTheSun.repository;

import com.SunLovers.PriseTheSun.model.Espaco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspacoRepository extends JpaRepository<Espaco, Long> {
    // Você pode adicionar consultas personalizadas aqui se necessário
}
