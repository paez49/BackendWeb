package com.example.demo.service;

import com.example.demo.domain.Equipo;
import com.example.demo.domain.Invitacion;
import com.example.demo.domain.Usuario;
import com.example.demo.dto.EquipoDTO;
import com.example.demo.dto.InvitacionDTO;
import com.example.demo.dto.UsuarioDTO;
import com.example.demo.repository.InvitacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvitacionService {
    @Autowired
    InvitacionRepository invitacionRepository;

    @Autowired
    EquipoService equipoService;

    @Autowired
    UsuarioService usuarioService;

    public void crearInvitacion(Long equipoId, Long usuarioId) {
        Equipo equipo = equipoService.findById(equipoId);
        Usuario usuario = usuarioService.findById(usuarioId);

        Invitacion invitacion = new Invitacion();
        invitacion.setEquipo(equipo);
        invitacion.setUsuario(usuario);

        invitacionRepository.save(invitacion);
    }
    public List<Invitacion> obtenerInvitacionesPorIdUsuario(long idUsuario){
        return invitacionRepository.findByUsuarioId(idUsuario);
    }

    public void rechazarInvitacion(Long idInvitacion) {
        invitacionRepository.deleteById(idInvitacion);
    }


    public void aceptarInvitacion(InvitacionDTO invitacion) {

        UsuarioDTO usuario = invitacion.getUsuario();
        EquipoDTO equipo = invitacion.getEquipo();
        usuarioService.agregarUsuarioEquipo(usuario, equipo);
        invitacionRepository.deleteById(invitacion.getId());
    }
}
