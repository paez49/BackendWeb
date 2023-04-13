package com.grupo4grupo1.demo.model;

import java.util.HashSet;
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
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;

import lombok.Singular;
import org.hibernate.annotations.Where;

@Data
@Builder
@AllArgsConstructor
@Entity
@Table(name = "equipo")
@SQLDelete(sql = "UPDATE equipo SET eliminado = true WHERE id=?")
@Where(clause = "eliminado=false")
public class Equipo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String nombreEquipo;
  private String siglas;
  private boolean eliminado = Boolean.FALSE;

  @ManyToMany(mappedBy = "equipos_participe", cascade = CascadeType.REMOVE)
  @Singular("jugador_en_equipo")
  private Set<Usuario> jugadores_en_equipo;

  @OneToMany(mappedBy = "equipo", cascade = CascadeType.REMOVE)
  private Set<Solicitud> solicitudes_de_jugadores;

  @OneToMany(mappedBy = "equipo", cascade = CascadeType.REMOVE)
  private Set<Invitacion> invitaciones_a_jugadores;
  public Equipo() {
    this.jugadores_en_equipo = new HashSet<>();
  }

}
