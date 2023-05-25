package com.example.demo.domain;

import java.util.HashSet;
import java.util.Set;

import lombok.*;
import org.hibernate.annotations.SQLDelete;

import org.hibernate.annotations.Where;

import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@Entity
@Table(name = "libro")
public class Libro {

  private String titulo;
  private String referencia;
  private String autor;
  private String precio;
  private String ubicacion;

  public Libro() {

  }

}
