package com.example.demo.dto;

import com.example.demo.domain.Usuario;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SolicitudDTO {
    private long id;
    private UsuarioDTO usuario;
}
