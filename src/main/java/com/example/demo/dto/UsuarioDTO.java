package com.example.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class UsuarioDTO {
    private long id;
    private String username;
    private String email;
    private String token;
}
