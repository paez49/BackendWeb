package com.example.demo.service;


import com.example.demo.domain.Equipo;
import com.example.demo.domain.Invitacion;
import com.example.demo.domain.Solicitud;
import com.example.demo.domain.Usuario;
import com.example.demo.repository.EquipoRepository;
import com.example.demo.security.payload.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PreRemove;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

@Service
public class EquipoService {

  @Autowired
  private EquipoRepository equipoRepository;
  @Autowired
  private SolicitudService solicitudesService;

  @Autowired
  private InvitacionService invitacionService;
  @Autowired
  private UsuarioService usuarioService;

  private EntityManager entityManager;

  public Iterable<Equipo> findAll(){
    return equipoRepository.findAll();
  }
  public Equipo findById(Long id) {
    Optional<Equipo> equipoOptional = equipoRepository.findById(id);
    return equipoOptional.orElseThrow(() -> new RuntimeException("Equipo no encontrado"));
  }
  public Equipo save(Equipo equipo) {
    return equipoRepository.save(equipo);
  }
  public List<Equipo> buscarEquiposDisponibles(Long idUsuario){
    return equipoRepository.buscarEquiposDisponibles(idUsuario);
  }

  public ResponseEntity<?> delete(Long idEquipo) {
    try {
      Equipo equipo = findById(idEquipo);
      for (Invitacion invitacion: equipo.getInvitaciones_a_jugadores()) {
        invitacionService.delete(invitacion.getId());
      }
      equipo.getInvitaciones_a_jugadores().clear();

      for(Solicitud solicitud: equipo.getSolicitudes_de_jugadores()){
        solicitudesService.delete(solicitud.getId());
      }
      equipo.getSolicitudes_de_jugadores().clear();

      for(Usuario usuario : equipo.getJugadores_en_equipo()){
        usuario.getEquipos_participe().remove(equipo);
      }
      equipoRepository.delete(equipo);

      return ResponseEntity.ok(new MessageResponse("El equipo con ID " + idEquipo + " fue eliminado exitosamente."));
    } catch (NoSuchElementException e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MessageResponse("No se encontró el equipo con ID " + idEquipo + "."));
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new MessageResponse("Ocurrió un error al eliminar el equipo con ID " + idEquipo + "."));
    }

  }

  public Set<Equipo> buscarEquiposParticipe(Long idUsuario) {
    Usuario usuario = usuarioService.findById(idUsuario);
    return usuario.getEquipos_participe();

  }
}
