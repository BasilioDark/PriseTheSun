package com.SunLovers.PriseTheSun.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.SunLovers.PriseTheSun.model.Organizador;

@Repository
public interface OrganizadorRepository extends JpaRepository<Organizador, Long> {

    @Modifying
    @Query("INSERT INTO Organizador SELECT u.id FROM Usuario u WHERE u.id = :usuarioId")
    void inserirOrganizador(@Param("usuarioId") long usuarioId);
}