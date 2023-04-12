package com.grupo4grupo1.demo;

import com.grupo4grupo1.demo.model.Equipo;
import com.grupo4grupo1.demo.model.Invitacion;
import com.grupo4grupo1.demo.model.Usuario;
import com.grupo4grupo1.demo.repository.EquipoRepository;
import com.grupo4grupo1.demo.repository.InvitacionRepository;
import com.grupo4grupo1.demo.repository.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class JugadorTest {

  @Autowired
  UsuarioRepository userRepository;
  @Autowired
  EquipoRepository equipoRepository;
  @Autowired
  InvitacionRepository invitacionRepository;

  @Test
  public void testCrearInvitacion() {

    Usuario usuario = userRepository.findById((long) 1).get();
    Equipo equipo = equipoRepository.findById((long) 1).get();

    System.out.println(usuario.getNombre());
    System.out.println(equipo.getNombreEquipo());
    // Crear una nueva invitación
    Invitacion invitacion = new Invitacion();
    invitacion.setUsuario(usuario);
    invitacion.setEquipo(equipo);
    invitacionRepository.save(invitacion);

    // Verificar que la invitación se haya creado correctamente
    assertNotNull(invitacion.getId());
  }
}


