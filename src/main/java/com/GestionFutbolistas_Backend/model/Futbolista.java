package com.GestionFutbolistas_Backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "futbolista")
public class Futbolista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombres;
    private String apellidos;
    private Date fechaNacimiento;
    private String caracteristicas;

    @ManyToOne
    @JoinColumn(name = "ID_Posicion", referencedColumnName = "id")
    private Posicion posicion;

}

