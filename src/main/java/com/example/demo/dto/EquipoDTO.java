package com.example.demo.dto;

import lombok.Data;

@Data
public class EquipoDTO {
    private long id;
    private String nombreEquipo;
    private String siglas;
    private boolean eliminado;

}
