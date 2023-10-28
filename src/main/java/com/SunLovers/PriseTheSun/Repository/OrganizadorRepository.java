package com.SunLovers.PriseTheSun.Repository;

import com.SunLovers.PriseTheSun.model.Organizador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizadorRepository extends JpaRepository<Organizador, Long> {
    // Métodos específicos de Organizador, se necessário
}