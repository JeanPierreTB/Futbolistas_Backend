package com.GestionFutbolistas_Backend.controlador;

import com.GestionFutbolistas_Backend.Repositorio.PosicionRepositorio;
import com.GestionFutbolistas_Backend.model.Posicion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class PosicionController {
    @Autowired
    private PosicionRepositorio posicionRepositorio;

    @PostMapping("/posiciones")
    public ResponseEntity<Posicion> crearPosicion(@RequestBody Posicion posicion) {
        Posicion nuevaPosicion = posicionRepositorio.save(posicion);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaPosicion);
    }
}
