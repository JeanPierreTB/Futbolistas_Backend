package com.GestionFutbolistas_Backend.controlador;


import com.GestionFutbolistas_Backend.Repositorio.FutbolistaRepositorio;
import com.GestionFutbolistas_Backend.expection.ResourceNotFoundException;
import com.GestionFutbolistas_Backend.model.Futbolista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class FutbolistaControllewr {

    @Autowired
    private FutbolistaRepositorio futbolistaRepositorio;

    @GetMapping("/futbolistas")
    public List<Futbolista> listarFutbolista(){
        return futbolistaRepositorio.findAll();
    }

    @PostMapping("/futbolistas")
    public ResponseEntity<Futbolista> guardarFutbolista(@RequestBody Futbolista futbolista) {
        Futbolista nuevoFutbolista = futbolistaRepositorio.save(futbolista);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoFutbolista);
    }

    @GetMapping("/futbolistas/{id}")
    public ResponseEntity<Futbolista> listarfutblistaporid(@PathVariable int id){
        Futbolista futbolista=futbolistaRepositorio.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("El futbolista con ese id no existe"));
        return ResponseEntity.ok(futbolista);
    }

    @DeleteMapping("/futbolistas/{id}")
    public ResponseEntity<?> eliminarFutbolista(@PathVariable int id) {
        Futbolista futbolista = futbolistaRepositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Futbolista no encontrado con ID: " + id));
        futbolistaRepositorio.delete(futbolista);
        return ResponseEntity.ok().build();
    }

}
