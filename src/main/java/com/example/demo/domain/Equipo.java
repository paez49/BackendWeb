package com.example.demo.domain;

import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;

import lombok.Singular;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Data
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
  private boolean eliminado= Boolean.FALSE;

  @ManyToMany(mappedBy = "equipos_participe", cascade = CascadeType.REMOVE)
  private Set<Usuario> jugadores_en_equipo;

  @OneToMany(mappedBy = "equipo", cascade = CascadeType.REMOVE)
  private Set<Solicitud> solicitudes_de_jugadores;

  @OneToMany(mappedBy = "equipo", cascade = CascadeType.REMOVE)
  private Set<Invitacion> invitaciones_a_jugadores;
  public Equipo() {
    this.jugadores_en_equipo = new HashSet<>();
  }

}
