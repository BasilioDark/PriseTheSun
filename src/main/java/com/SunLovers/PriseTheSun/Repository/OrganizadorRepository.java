package com.SunLovers.PriseTheSun.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.SunLovers.PriseTheSun.model.Organizador;

@Repository
public interface OrganizadorRepository extends JpaRepository<Organizador, Long> {
  

  
}