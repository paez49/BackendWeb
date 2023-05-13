package com.example.demo.util;

import com.example.demo.domain.Equipo;
import com.example.demo.domain.Invitacion;
import com.example.demo.domain.Solicitud;
import com.example.demo.domain.Usuario;
import com.example.demo.dto.EquipoDTO;
import com.example.demo.dto.InvitacionDTO;
import com.example.demo.dto.SolicitudDTO;
import com.example.demo.dto.UsuarioDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Set;
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
    public SolicitudDTO toDto(Solicitud solicitud){
        SolicitudDTO solicitudDTO = modelMapper.map(solicitud, SolicitudDTO.class);
        return solicitudDTO;
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
    public List<InvitacionDTO> toDtoListInvitaciones(List<Invitacion> invitaciones){
        List<InvitacionDTO> invitacionesDTO = invitaciones.stream()
                .map(invitacion -> modelMapper.map(invitacion, InvitacionDTO.class))
                .collect(Collectors.toList());
        return invitacionesDTO;
    }
    public List<SolicitudDTO> toDtoListSolicitudes(List<Solicitud> solicitudes){
        List<SolicitudDTO> solicitudesDTO = solicitudes.stream()
                .map(solicitud -> modelMapper.map(solicitud, SolicitudDTO.class))
                .collect(Collectors.toList());
        return solicitudesDTO;
    }

    public List<EquipoDTO> toDtoSetEquipos(Set<Equipo> equipos) {
        List<EquipoDTO> equiposDTO = equipos.stream()
                .map(equipo -> modelMapper.map(equipo, EquipoDTO.class))
                .collect(Collectors.toList());
        return equiposDTO;
    }
    public Equipo toEntity(EquipoDTO equipoDTO) {
        Equipo equipo = new Equipo();
        equipo.setNombreEquipo(Objects.requireNonNullElse(equipoDTO.getNombreEquipo(), "default"));
        equipo.setSiglas(Objects.requireNonNullElse(equipoDTO.getSiglas(), "def"));
        return equipo;
    }

}
