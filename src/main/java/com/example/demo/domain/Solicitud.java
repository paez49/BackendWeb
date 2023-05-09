package com.example.demo.domain;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name ="solicitud", uniqueConstraints = {@UniqueConstraint(columnNames = {"id_usuario", "id_equipo"})})
public class Solicitud {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Boolean aceptada;

    @ManyToOne
    @JoinColumn(name="id_usuario",nullable = false,referencedColumnName="id")
    Usuario usuario;

    @ManyToOne()
    @JoinColumn(name = "id_equipo")
    Equipo equipo;
}
