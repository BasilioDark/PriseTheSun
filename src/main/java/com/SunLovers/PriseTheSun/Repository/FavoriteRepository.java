package com.SunLovers.PriseTheSun.repository;

import com.SunLovers.PriseTheSun.model.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Long> {

    // Method to find a favorite by Usuario ID and Atividade ID
    Optional<Favorite> findByUsuarioIdAndAtividadeId(Long usuarioId, Long atividadeId);

    // Method to find all favorites for a specific Usuario
    List<Favorite> findAllByUsuarioId(Long usuarioId);
}
