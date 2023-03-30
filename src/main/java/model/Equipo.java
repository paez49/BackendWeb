package model;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nombreEquipo;
    private String siglas;

    @ManyToMany (mappedBy = "equipos_participe") 
    Set<Usuario> jugadores_en_equipo;
    @ManyToMany (mappedBy = "invitaciones")
    Set<Usuario> invitaciones_a_jugadores;
    @ManyToMany (mappedBy = "solicitudes")
    Set<Usuario> solicitudes_de_jugadores;
}
