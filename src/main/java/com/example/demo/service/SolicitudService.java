package com.example.demo.service;

import com.example.demo.domain.Equipo;
import com.example.demo.domain.Solicitud;
import com.example.demo.domain.Usuario;
import com.example.demo.dto.EquipoDTO;
import com.example.demo.dto.SolicitudDTO;
import com.example.demo.dto.UsuarioDTO;
import com.example.demo.repository.SolicitudRepository;
import com.example.demo.util.ConverterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class SolicitudService {
    @Autowired
    SolicitudRepository solicitudRepository;
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    EquipoService equipoService;
    ConverterDTO converterDTO = new ConverterDTO();

    public void crearSolicitud(Long idUsuario, Long idEquipo) {
        Usuario usuario = usuarioService.findById(idUsuario);
        Equipo equipo = equipoService.findById(idEquipo);

        Solicitud solicitud = new Solicitud();
        solicitud.setUsuario(usuario);
        solicitud.setEquipo(equipo);


        solicitudRepository.save(solicitud);
    }
    public List<Solicitud> obtenerSolcitudesPorIdEquipo(long idEquipo){
        return solicitudRepository.findByEquipoId(idEquipo);
    }

    public void delete(Long id) {
        solicitudRepository.deleteById(id);
    }
    
    public void rechazarSolicitud(Long idSolicitud) {
        solicitudRepository.deleteById(idSolicitud);
    }

    public void aceptarSolicitud(Long idSolicitud) {
        Solicitud solicitud = solicitudRepository.getById(idSolicitud);
        UsuarioDTO usuario = converterDTO.toDto(solicitud.getUsuario());
        EquipoDTO equipo = converterDTO.toDto(solicitud.getEquipo());
        usuarioService.agregarUsuarioEquipo(usuario, equipo);
        solicitudRepository.deleteById(solicitud.getId());
    }
}
