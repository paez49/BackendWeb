package com.grupo4grupo1.demo.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;


@Data

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private String apellido;
    private String correo;
    private String password;

    @ManyToMany
    @JoinTable(
        name = "jugadores_en_equipo",
        joinColumns = @JoinColumn(name = "usuario_id"),
        inverseJoinColumns = @JoinColumn(name = "equipo_id")
    )
    private Set<Equipo> equipos_participe;

    @OneToMany(mappedBy = "usuario")
    private Set<Invitacion> invitaciones_de_equipos;

    @OneToMany(mappedBy = "usuario")
    private Set<Solicitud> solicitudes_a_equipos;
}
