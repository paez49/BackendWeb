package com.grupo4grupo1.demo;

import com.grupo4grupo1.demo.model.Equipo;
import com.grupo4grupo1.demo.model.Invitacion;
import com.grupo4grupo1.demo.model.Solicitud;
import com.grupo4grupo1.demo.model.Usuario;
import com.grupo4grupo1.demo.repository.EquipoRepository;
import com.grupo4grupo1.demo.repository.InvitacionRepository;
import com.grupo4grupo1.demo.repository.SolicitudRepository;
import com.grupo4grupo1.demo.repository.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
public class InvitacionSolicitudTest {

  @Autowired
  UsuarioRepository userRepository;
  @Autowired
  EquipoRepository equipoRepository;
  @Autowired
  SolicitudRepository solicitudRepository;
  @Autowired
  InvitacionRepository invitacionRepository;


  @Test
  public void testCrearSolicitud() {

    //Confirmar que tanto el jugador como el equipo existen en la base de datos
    Usuario usuario = userRepository.findById((long) 1).get();
    Equipo equipo = equipoRepository.findById((long) 1).get();

    // Crear una nueva solicitud
    Solicitud solicitud = new Solicitud();
    solicitud.setUsuario(usuario);
    solicitud.setEquipo(equipo);
    solicitudRepository.save(solicitud);

    // Verificar que la solicitud se haya creado correctamente
    assertNotNull(solicitud.getId());
    System.out.println(solicitud.getId());
  }
  @Test
  public void testSolicitudExistente(){
    Usuario usuario = userRepository.findById((long) 1).get();
    Equipo equipo = equipoRepository.findById((long) 1).get();
// Intentar crear otra invitación con los mismos detalles
    Solicitud otraSolicitud = new Solicitud();
    otraSolicitud.setUsuario(usuario);
    otraSolicitud.setEquipo(equipo);
    try {
      solicitudRepository.save(otraSolicitud);
      fail("Se esperaba una excepción de tipo DataIntegrityViolationException");
    } catch (DataIntegrityViolationException ex) {
      // La excepción fue lanzada, lo que indica que la prueba pasó correctamente
    }
  }
  @Test
  public void testCrearInvitacion() {

    //Confirmar que tanto el jugador como el equipo existen en la base de datos
    Usuario usuario = userRepository.findById((long) 1).get();
    Equipo equipo = equipoRepository.findById((long) 1).get();

    // Crear una nueva invitación
    Invitacion invitacion = new Invitacion();
    invitacion.setUsuario(usuario);
    invitacion.setEquipo(equipo);
    invitacionRepository.save(invitacion);

    // Verificar que la invitación se haya creado correctamente
    assertNotNull(invitacion.getId());
    System.out.println(invitacion.getId());
  }
  @Test
  public void testInvitacionExistente(){
    Usuario usuario = userRepository.findById((long) 1).get();
    Equipo equipo = equipoRepository.findById((long) 1).get();
// Intentar crear otra invitación con los mismos detalles
    Invitacion otraInvitacion = new Invitacion();
    otraInvitacion.setUsuario(usuario);
    otraInvitacion.setEquipo(equipo);
    try {
      invitacionRepository.save(otraInvitacion);
      fail("Se esperaba una excepción de tipo DataIntegrityViolationException");
    } catch (DataIntegrityViolationException ex) {
      // La excepción fue lanzada, lo que indica que la prueba pasó correctamente
    }
  }
}
