package model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter 
@AllArgsConstructor
@Entity

@Table (name = "usuario")
public class Usuario {
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_usuario;
    @Column (name = "nombre_usuario")
    private String nombre;
    private String password;

    @ManyToMany
    @JoinTable(
        name = "lista_equipos_participe",
        joinColumns = @JoinColumn(name="id_usuario"),
        inverseJoinColumns = @JoinColumn(name = "id_equipo")
    )
    Set<Equipo> equipos_participe;
    @ManyToMany
    //Solicitudes de jugadores de entrar a un equipo
    @JoinTable(
        name = "solicitudes_a_equipos",
        joinColumns = @JoinColumn(name="id_usuario"),
        inverseJoinColumns = @JoinColumn(name = "id_equipo")
    )
    Set<Equipo> solicitudes;
    //Solicitudes de equ
    @ManyToMany
    @JoinTable(
        name = "invitaciones_a_jugadores",
        joinColumns = @JoinColumn(name="id_usuario"),
        inverseJoinColumns = @JoinColumn(name = "id_equipo")
    )
    Set<Equipo> invitaciones;

}
