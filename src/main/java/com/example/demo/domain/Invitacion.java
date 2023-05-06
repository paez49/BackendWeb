package com.example.demo.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name ="invitacion", uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "team_id"})})
public class Invitacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Boolean aceptada;


    @ManyToOne()
    @JoinColumn(name="user_id",nullable=false,referencedColumnName="id")
    Usuario usuario;

    @ManyToOne()
    @JoinColumn(name="team_id")
    Equipo equipo;
}
