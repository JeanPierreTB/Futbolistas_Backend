package com.GestionFutbolistas_Backend.Repositorio;

import com.GestionFutbolistas_Backend.model.Futbolista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FutbolistaRepositorio  extends JpaRepository<Futbolista,Integer> {
}
