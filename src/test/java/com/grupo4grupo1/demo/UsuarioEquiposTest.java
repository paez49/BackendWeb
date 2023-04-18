package com.grupo4grupo1.demo;


import com.grupo4grupo1.demo.model.Equipo;
import com.grupo4grupo1.demo.model.Usuario;
import com.grupo4grupo1.demo.repository.EquipoRepository;
import com.grupo4grupo1.demo.repository.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class UsuarioEquiposTest {
  @Autowired
  UsuarioRepository usuarioRepository;

  @Autowired
  EquipoRepository equipoRepository;

  @Test
  public void testCrearUsuarios(){
    try {
      Iterator<Usuario> usuarios = usuarioRepository.findAll().iterator();
      int cantidad = 0;
      while( usuarios.hasNext() ) {
        usuarios.next();
        cantidad ++;
      }

      Usuario user = new Usuario();
      user.setNombre("Juan");
      user.setCorreo("Juan@Paez.es");
      user.setPassword("test");
      usuarioRepository.save(user);


      user = new Usuario();
      user.setNombre("Juan");
      user.setCorreo("Juan@Sanchez.es");
      user.setPassword("test123");
      usuarioRepository.save(user);


      int nuevaCantidad = 0;
      usuarios = usuarioRepository.findAll().iterator();
      while( usuarios.hasNext() ) {
        usuarios.next();
        nuevaCantidad ++;
      }

      assertTrue(cantidad + 2 == nuevaCantidad, "Si se agregarón los usuarios");
    }catch (Exception e){
      e.printStackTrace();
      assertTrue(false,"Error");
    }



  }
  @Test
  public void testCrearEquipos(){
    try {
      Iterator<Equipo> equipos = equipoRepository.findAll().iterator();
      int cantidad = 0;
      while( equipos.hasNext() ) {
        equipos.next();
        cantidad ++;
      }
      Equipo equipo = new Equipo();
      equipo.setNombreEquipo("Eskere FC");
      equipo.setSiglas("EFC");
      equipoRepository.save(equipo);

      equipo = new Equipo();
      equipo.setNombreEquipo("Hola FC");
      equipo.setSiglas("HFC");
      equipoRepository.save(equipo);


      int nuevaCantidad = 0;

      equipos = equipoRepository.findAll().iterator();
      while( equipos.hasNext() ) {
        equipos.next();
        nuevaCantidad ++;
      }

      assertTrue(cantidad + 2 == nuevaCantidad, "Si se agregarón los equipos");
    }catch (Exception e){
      e.printStackTrace();
      assertTrue(false,"Error");
    }



  }
}
