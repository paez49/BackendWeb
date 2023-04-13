package com.grupo4grupo1.demo.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table (name = "equipo")
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreEquipo;
    private String siglas;
    private boolean eliminado = false;

    @ManyToMany (mappedBy = "equipos_participe", cascade = CascadeType.REMOVE)
    Set<Usuario> jugadores_en_equipo;

    @OneToMany(mappedBy = "equipo", cascade = CascadeType.REMOVE)
    Set<Solicitud> solicitudes_de_jugadores;

    @OneToMany(mappedBy = "equipo", cascade = CascadeType.REMOVE)
    Set<Invitacion> invitaciones_a_jugadores;
}
