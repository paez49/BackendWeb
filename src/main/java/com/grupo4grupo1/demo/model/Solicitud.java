package com.grupo4grupo1.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name ="solicitud", uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "team_id"})})
public class Solicitud {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Boolean aceptada;

    @ManyToOne
    @JoinColumn(name="user_id",nullable = false,referencedColumnName="id")
    Usuario usuario;

    @ManyToOne()
    @JoinColumn(name = "team_id")
    Equipo equipo;
}
