package com.example.demo.service;

import com.example.demo.domain.Equipo;
import com.example.demo.domain.Invitacion;
import com.example.demo.domain.Usuario;
import com.example.demo.repository.InvitacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Invitacion save(Invitacion invitacion){
        return invitacionRepository.save(invitacion);
    }
    public Iterable<Invitacion> findAll(){
        return invitacionRepository.findAll();
    }



}
