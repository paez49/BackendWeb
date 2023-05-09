package com.example.demo.util;

import com.example.demo.domain.Equipo;
import com.example.demo.domain.Usuario;
import com.example.demo.dto.EquipoDTO;
import com.example.demo.dto.UsuarioDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class ConverterDTO {
    public ConverterDTO(){
        modelMapper = new ModelMapper();
    }
    private ModelMapper modelMapper;

    public EquipoDTO toDto(Equipo equipo){
        EquipoDTO equipoDTO = modelMapper.map(equipo, EquipoDTO.class);
        return equipoDTO;
    }
    public UsuarioDTO toDto(Usuario usuario){
        UsuarioDTO usuarioDTO = modelMapper.map(usuario, UsuarioDTO.class);
        return usuarioDTO;
    }
    public List<UsuarioDTO> toDtoListUsuarios(List<Usuario> usuarios) {
        List<UsuarioDTO> usuariosDTO = usuarios.stream()
                .map(usuario -> modelMapper.map(usuario, UsuarioDTO.class))
                .collect(Collectors.toList());
        return usuariosDTO;
    }
    public List<EquipoDTO> toDtoListEquipos(List<Equipo> equipos) {
        List<EquipoDTO> equiposDTO = equipos.stream()
                .map(equipo -> modelMapper.map(equipo, EquipoDTO.class))
                .collect(Collectors.toList());
        return equiposDTO;
    }
}
