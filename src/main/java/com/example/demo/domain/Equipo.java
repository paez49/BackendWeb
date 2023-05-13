package com.example.demo.domain;

import java.util.HashSet;
import java.util.Set;

import lombok.*;
import org.hibernate.annotations.SQLDelete;

import org.hibernate.annotations.Where;

import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@Entity
@Table(name = "equipo")
public class Equipo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String nombreEquipo;
  private String siglas;

  @ManyToMany(mappedBy = "equipos_participe", cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST })
  private Set<Usuario> jugadores_en_equipo;

  @OneToMany(mappedBy = "equipo", cascade = CascadeType.REMOVE)
  private Set<Solicitud> solicitudes_de_jugadores;

  @OneToMany(mappedBy = "equipo", cascade = CascadeType.REMOVE)
  private Set<Invitacion> invitaciones_a_jugadores;
  public Equipo() {
    this.jugadores_en_equipo = new HashSet<>();
  }

}
