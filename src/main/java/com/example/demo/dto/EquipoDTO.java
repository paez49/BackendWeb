package com.example.demo.dto;

import lombok.Data;
import lombok.Setter;

@Data
@Setter
public class EquipoDTO {
    private long id;
    private String nombreEquipo;
    private String siglas;
    private boolean eliminado;

}
