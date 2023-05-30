package com.example.demo.rest;

import com.example.demo.domain.Equipo;
import com.example.demo.domain.Usuario;
import com.example.demo.dto.EquipoDTO;
import com.example.demo.dto.UsuarioDTO;
import com.example.demo.service.EquipoService;
import com.example.demo.service.UsuarioService;
import com.example.demo.util.ConverterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    EquipoService equipoService;
    @Autowired
    private ConverterDTO converterDTO;
    @GetMapping("/noEnEquipo/{idEquipo}")
    public ResponseEntity<List<UsuarioDTO>> getUsuariosNoEnEquipo(@PathVariable Long idEquipo) {
        List<Usuario> usuarios = usuarioService.findAllUsuariosNotInEquipo(idEquipo);
        List<UsuarioDTO> usuariosDTO = converterDTO.toDtoListUsuarios(usuarios);
        return ResponseEntity.ok(usuariosDTO);
    }
}
