package com.GestionFutbolistas_Backend.Repositorio;

import com.GestionFutbolistas_Backend.model.Posicion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PosicionRepositorio extends JpaRepository<Posicion, Integer> {
}
