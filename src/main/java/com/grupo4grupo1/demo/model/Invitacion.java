package com.grupo4grupo1.demo.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name ="invitacion")
public class Invitacion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;


    @ManyToOne()
    @JoinColumn(name="user_id",nullable=false,referencedColumnName="id")
    Usuario usuario;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="team_id",nullable = false)
    Equipo equipo;
}
