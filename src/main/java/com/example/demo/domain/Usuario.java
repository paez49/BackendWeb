package com.example.demo.domain;

import java.util.Set;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String email;
    private String password;
    public Usuario(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinTable(
        name = "jugadores_en_equipo",
        joinColumns = @JoinColumn(name = "id_usuario"),
        inverseJoinColumns = @JoinColumn(name = "id_equipo")
    )
    private Set<Equipo> equipos_participe;

    @OneToMany(mappedBy = "usuario",cascade= CascadeType.REMOVE)
    private Set<Invitacion> invitaciones_de_equipos;

    @OneToMany(mappedBy = "usuario",cascade = CascadeType.REMOVE)
    private Set<Solicitud> solicitudes_a_equipos;

    public Usuario() {

    }
}

