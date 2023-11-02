package com.SunLovers.PriseTheSun.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.SunLovers.PriseTheSun.model.Organizador;

@Repository
public interface OrganizadorRepository extends JpaRepository<Organizador, Long> {
  
    @Modifying
    @Query(nativeQuery = true, value = "INSERT INTO organizador (ID) VALUES (:id)")
    @Transactional
    void TransformarEmOrganizador(@Param("id") Long id);
}