package com.example.demo.jpa;


import com.example.demo.domain.Libro;
import com.example.demo.domain.Usuario;
import com.example.demo.repository.EquipoRepository;
import com.example.demo.repository.UsuarioRepository;
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

      user.setUsername("Juan");
      user.setEmail("Juan@Paez.es");
      user.setPassword("test");
      usuarioRepository.save(user);


      user = new Usuario();
      user.setUsername("Juan");
      user.setEmail("Juan@Sanchez.es");
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
      Iterator<Libro> equipos = equipoRepository.findAll().iterator();
      int cantidad = 0;
      while( equipos.hasNext() ) {
        equipos.next();
        cantidad ++;
      }
      Libro equipo = new Libro();
      equipo.setNombreEquipo("Eskere FC");
      equipo.setSiglas("EFC");
      equipoRepository.save(equipo);

      equipo = new Libro();
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
