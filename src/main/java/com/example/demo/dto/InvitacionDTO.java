package com.example.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class InvitacionDTO {
    private long id;
    private UsuarioDTO usuario;
    private EquipoDTO equipo;
}
