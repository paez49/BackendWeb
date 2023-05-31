package com.example.demo.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name ="invitacion", uniqueConstraints = {@UniqueConstraint(columnNames = {"id_usuario", "id_equipo"})})
public class Invitacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne()
    @JoinColumn(name="id_usuario",nullable=false,referencedColumnName="id")
    Usuario usuario;

    @ManyToOne()
    @JoinColumn(name="id_equipo")
    Equipo equipo;
}