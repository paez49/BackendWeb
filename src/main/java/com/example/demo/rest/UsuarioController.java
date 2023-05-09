package com.example.demo.rest;

import com.example.demo.domain.Equipo;
import com.example.demo.domain.Usuario;
import com.example.demo.dto.EquipoDTO;
import com.example.demo.dto.UsuarioDTO;
import com.example.demo.service.EquipoService;
import com.example.demo.service.UsuarioService;
import com.example.demo.util.ConverterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    EquipoService equipoService;
    @Autowired
    private ConverterDTO converterDTO;
    @GetMapping("/usuarios")
    public List<UsuarioDTO> findAll() {
        List<Usuario> usuarios = (List<Usuario>) usuarioService.findAll();
        List<UsuarioDTO> usuariosDTO = converterDTO.toDtoListUsuarios(usuarios);
        return usuariosDTO;
    }
    //Obtener todos los equipos los cuales el usuario no pertenece
    //Lista equipos -> Presentacion lista de equipos
    @GetMapping("/usuarios/{id}/equipos_disponibles")
    public List<EquipoDTO> obtenerEquiposDisponibles(@PathVariable Long id) {
        List<Equipo> equipos = equipoService.buscarEquiposDisponibles(id);
        List<EquipoDTO> equipoDTO = converterDTO.toDtoListEquipos(equipos);
        return equipoDTO;
    }
}
